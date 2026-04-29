package ph.edu.dlsu.animove.domain.category

import java.util.UUID

/**
 * Represents a category of lines with a reservation capacity limit.
 *
 * Invariants:
 * - name must be trimmed
 * - name must not be blank
 * - name length must be at most 63 characters
 *
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
    companion object {
        const val MAX_NAME_LENGTH = 63
    }

    var name: String = name
        set(value) {
            val normalized = value.trim()

            require(normalized.isNotBlank()) { "Name must not be blank" }
            require(normalized.length <= MAX_NAME_LENGTH) { "Name must not exceed $MAX_NAME_LENGTH characters" }

            field = normalized
        }

    var reservationCapacity: Int = reservationCapacity
        set(value) {
            require(value > 0) { "Reservation capacity must be greater than 0" }
            field = value
        }

    init {
        this.name = name
        this.reservationCapacity = reservationCapacity
    }
}