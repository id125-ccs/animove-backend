package application.category.handler

import application.category.command.UpdateCategoryReservationCapacityCommand
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import ph.edu.dlsu.animove.domain.category.ReservationCapacity
import ph.edu.dlsu.animove.domain.error.DomainError

sealed interface UpdateCategoryReservationCapacityResult {
    object Success : UpdateCategoryReservationCapacityResult

    object NotFound : UpdateCategoryReservationCapacityResult

    data class ValidationFailed(val error: DomainError) : UpdateCategoryReservationCapacityResult

    data class InternalError(val cause: Throwable) : UpdateCategoryReservationCapacityResult
}

class UpdateCategoryReservationCapacityHandler(private val categoryRepository: CategoryRepository) {
    fun handle(command: UpdateCategoryReservationCapacityCommand): UpdateCategoryReservationCapacityResult = try {
        val category = categoryRepository.findById(command.categoryId)
            ?: return UpdateCategoryReservationCapacityResult.NotFound

        val newReservationCapacity = ReservationCapacity(command.newReservationCapacity)

        category.reservationCapacity = newReservationCapacity

        UpdateCategoryReservationCapacityResult.Success
    } catch (e: DomainError) {
        UpdateCategoryReservationCapacityResult.ValidationFailed(e)
    } catch (e: Throwable) {
        UpdateCategoryReservationCapacityResult.InternalError(e)
    }
}