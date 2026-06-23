package application.category.command

import java.util.UUID

data class UpdateCategoryReservationCapacityCommand(
    val categoryId: UUID,
    val newReservationCapacity: Int
)