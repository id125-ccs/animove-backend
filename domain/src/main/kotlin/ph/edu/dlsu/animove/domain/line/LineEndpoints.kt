package ph.edu.dlsu.animove.domain.line

/**
 * Represents the two terminal locations of a line.
 *
 * Invariants:
 * - a and b must be distinct locations
 *
 * Direction is not encoded here.
 */
data class LineEndpoints(
    val a: Endpoint,
    val b: Endpoint
) {
    init {
        require(a != b) { "Line endpoints must be distinct locations" }
    }
}

/**
 * Represents the travel direction of a line relative to its endpoints.
 *
 * A direction indicates whether a trip operates from endpoint A to
 * endpoint B or from endpoint B to endpoint A.
 */
enum class Direction {
    A_TO_B, B_TO_A
}