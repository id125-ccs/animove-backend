package ph.edu.dlsu.animove.domain.category

import java.util.UUID

/**
 * Represents a category with a name and a reservation capacity limit.
 *
 * @property id Unique identifier of the category.
 * @param name The display name of the category.
 * @param reservationCapacity Maximum number of reservations allowed for this category.
 *
 * @constructor Creates a new Category with validation on the provided [name] and [reservationCapacity].
 */
class Category(
    val id: UUID,
    name: String,
    reservationCapacity: Int
) {
    /**
     * The display name of the category.
     * @throws IllegalArgumentException if the assigned value is blank or empty.
     */
    var name: String = name
        set(value) {
            require(value.isNotBlank()) { "Name must not be blank" }
            field = value
        }

    /**
     * The maximum number of reservations allowed for this category.
     * @throws IllegalArgumentException if the assigned value is less than or equal to 0.
     */
    var reservationCapacity: Int = reservationCapacity
        set(value) {
            require(value > 0) { "Reservation capacity must be greater than 0" }
            field = value
        }
}