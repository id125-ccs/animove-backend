package application.category.command

data class CreateCategoryCommand(
    val name: String,
    val reservationCapacity: Int
)