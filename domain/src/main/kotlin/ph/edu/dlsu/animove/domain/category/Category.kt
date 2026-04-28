package ph.edu.dlsu.animove.domain.category

import java.util.UUID

/**
 * Represents a category of lines with a reservation capacity limit.
 *
 * Invariants:
 * - name must not be blank
 * - reservationCapacity must be greater than 0
 *
 * @property id Unique identifier of the category.
 * @property name Display name of the category.
 * @property reservationCapacity Maximum number of reservations allowed.
 */
class Category(
    val id: UUID,
    name: String,
    reservationCapacity: Int
) {
    var name: String = name
        set(value) {
            require(value.isNotBlank()) { "Name must not be blank" }
            field = value
        }

    var reservationCapacity: Int = reservationCapacity
        set(value) {
            require(value > 0) { "Reservation capacity must be greater than 0" }
            field = value
        }
}