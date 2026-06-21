package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.error.ValidationError

class IdenticalLineEndpoints: ValidationError("Line endpoints must be distinct locations")

/**
 * Represents the two terminal locations of a line.
 *
 * Invariants:
 * - a and b must be distinct locations
 *
 * Direction is not encoded here.
 *
 * @throws IdenticalLineEndpoints if [a] and [b] refer to the same [Endpoint].
 */
data class LineEndpoints(
    val a: Endpoint,
    val b: Endpoint
) {
    init {
        if (a == b)
            throw IdenticalLineEndpoints()
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