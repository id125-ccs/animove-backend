package application.category.command

import java.util.UUID

data class RenameCategoryCommand(
    val categoryId: UUID,
    val newName: String
)