package application.category.handler

import application.category.command.RenameCategoryCommand
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import ph.edu.dlsu.animove.domain.error.DomainError
import ph.edu.dlsu.animove.domain.shared.Name

sealed interface RenameCategoryResult {
    object Success : RenameCategoryResult

    object NotFound : RenameCategoryResult

    object NameAlreadyTaken : RenameCategoryResult

    data class ValidationFailed(val error: DomainError) : RenameCategoryResult

    data class InternalError(val cause: Throwable) : RenameCategoryResult
}

class RenameCategoryHandler(
    private val categoryRepository: CategoryRepository
) {
    fun handle(command: RenameCategoryCommand): RenameCategoryResult = try {
        val category = categoryRepository.findById(command.categoryId) ?: return RenameCategoryResult.NotFound

        val newName = Name.create(command.newName)

        if (categoryRepository.existsByName(newName))
            return RenameCategoryResult.NameAlreadyTaken

        category.name = newName

        categoryRepository.save(category)

        RenameCategoryResult.Success
    } catch (e: DomainError) {
        RenameCategoryResult.ValidationFailed(e)
    } catch (e: Throwable) {
        RenameCategoryResult.InternalError(e)
    }
}