package ph.edu.dlsu.animove.domain.category

import ph.edu.dlsu.animove.domain.shared.Name
import java.util.UUID

/**
 * Represents a category of lines with a reservation capacity limit.
 *
 * @property id Unique identifier of the category.
 * @property name Display name of the category.
 * @property reservationCapacity Maximum number of reservations allowed.
 */
class Category(
    val id: UUID,
    var name: Name,
    reservationCapacity: Int
) {
    var reservationCapacity: Int = reservationCapacity
        set(value) {
            require(value > 0) { "Reservation capacity must be greater than 0" }
            field = value
        }

    init {
        this.reservationCapacity = reservationCapacity
    }
}