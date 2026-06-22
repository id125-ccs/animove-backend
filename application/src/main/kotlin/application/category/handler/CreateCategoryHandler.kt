package application.category.handler

import application.category.command.CreateCategoryCommand
import ph.edu.dlsu.animove.domain.category.Category
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import ph.edu.dlsu.animove.domain.category.ReservationCapacity
import ph.edu.dlsu.animove.domain.error.DomainError
import ph.edu.dlsu.animove.domain.shared.Name
import java.util.UUID

sealed interface CreateCategoryResult {
    data class Success(val id: UUID) : CreateCategoryResult

    data class ValidationFailed(val error: DomainError) : CreateCategoryResult

    data class InternalError(val cause: Throwable) : CreateCategoryResult
}

class CreateCategoryHandler(private val categoryRepository: CategoryRepository, private val nextId: () -> UUID) {
    fun handle(command: CreateCategoryCommand): CreateCategoryResult {
        return try {
            val category = Category(
                nextId(), Name.create(command.name), ReservationCapacity(command.reservationCapacity)
            )

            categoryRepository.save(category)

            CreateCategoryResult.Success(category.id)
        } catch (e: DomainError) {
            CreateCategoryResult.ValidationFailed(e)
        } catch (e: Throwable) {
            CreateCategoryResult.InternalError(e)
        }
    }
}