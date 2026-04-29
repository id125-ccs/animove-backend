package ph.edu.dlsu.animove.domain.shared

/**
 * Represents a geographic coordinate on Earth.
 *
 * Invariants:
 * - latitude must be within [-90.0, 90.0]
 * - longitude must be within [-180.0, 180.0]
 *
 * @property latitude Latitude in degrees.
 * @property longitude Longitude in degrees.
 */
data class Coordinate(
    val latitude: Double,
    val longitude: Double
) {
    companion object {
        const val MINIMUM_LATITUDE = -90.0
        const val MAXIMUM_LATITUDE = 90.0
        const val MINIMUM_LONGITUDE = -180.0
        const val MAXIMUM_LONGITUDE = 180.0
    }

    init {
        require(latitude in MINIMUM_LATITUDE..MAXIMUM_LATITUDE) {
            "Latitude must be between $MINIMUM_LATITUDE and $MAXIMUM_LATITUDE"
        }
        require(longitude in MINIMUM_LONGITUDE..MAXIMUM_LONGITUDE) {
            "Longitude must be between $MINIMUM_LONGITUDE and $MAXIMUM_LONGITUDE"
        }
    }
}