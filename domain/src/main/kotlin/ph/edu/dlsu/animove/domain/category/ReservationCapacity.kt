package ph.edu.dlsu.animove.domain.category

/**
 * Represents the maximum number of reservations allowed.
 *
 * @property value Maximum number of reservations.
 */
@JvmInline
value class ReservationCapacity(val value: Int) {
    companion object {
        const val MINIMUM_RESERVATION_CAPACITY = 1
    }

    init {
        require(value >= MINIMUM_RESERVATION_CAPACITY) {
            "Reservation capacity must be at least $MINIMUM_RESERVATION_CAPACITY"
        }
    }
}