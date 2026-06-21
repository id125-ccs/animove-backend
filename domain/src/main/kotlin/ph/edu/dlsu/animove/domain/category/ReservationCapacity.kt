package ph.edu.dlsu.animove.domain.category

import ph.edu.dlsu.animove.domain.error.ValidationError

class ReservationCapacityTooLow(minimum: Int) : ValidationError("Reservation capacity must be at least $minimum")

/**
 * Represents the maximum number of reservations allowed.
 *
 * @property value Maximum number of reservations.
 *
 * @throws ReservationCapacityTooLow if [value] is less than [MINIMUM_RESERVATION_CAPACITY]
 */
@JvmInline
value class ReservationCapacity(val value: Int) {
    companion object {
        const val MINIMUM_RESERVATION_CAPACITY = 1
    }

    init {
        if (value < MINIMUM_RESERVATION_CAPACITY)
            throw ReservationCapacityTooLow(MINIMUM_RESERVATION_CAPACITY)
    }
}