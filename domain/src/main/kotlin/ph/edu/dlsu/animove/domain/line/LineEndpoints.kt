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