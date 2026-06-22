package application.category.handler

import application.category.command.DeleteCategoryCommand
import ph.edu.dlsu.animove.domain.category.CategoryRepository

sealed interface DeleteCategoryResult {
    object Success : DeleteCategoryResult

    data class InternalError(val cause: Throwable) : DeleteCategoryResult
}

class DeleteCategoryHandler(
    private val categoryRepository: CategoryRepository
) {
    fun handle(command: DeleteCategoryCommand): DeleteCategoryResult {
        return try {
            categoryRepository.delete(command.categoryId)

            DeleteCategoryResult.Success
        } catch (e: Throwable) {
            DeleteCategoryResult.InternalError(e)
        }
    }
}