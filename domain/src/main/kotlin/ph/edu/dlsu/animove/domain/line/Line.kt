package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.shared.Coordinate
import java.util.UUID
import kotlin.text.isNotBlank

/**
 * Represents a transit or shuttle line within the Animove system.
 *
 * Invariants:
 * - name must not be blank
 *
 * @property id Unique identifier of the line.
 * @property categoryId Category this line belongs to.
 * @property endpoints Start and end locations of the line.
 * @property name Display name of the line.
 */
class Line(
    val id: UUID,
    var categoryId: UUID,
    val endpoints: LineEndpoints,
    name: String,
) {
    var name: String = name
        set(value) {
            require(value.isNotBlank()) { "Line name must not be blank" }
            field = value
        }

    init {
        this.name = name
    }
}

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
 * Represents a named geographic point in the system.
 *
 * Invariants:
 * - name must not be blank
 * - address must not be blank
 *
 * @property name Display name of an endpoint.
 * @property address Human-readable address of the endpoint.
 * @property coordinate Geographic position of the endpoint.
 */
data class Endpoint(
    val name: String,
    val address: String,
    val coordinate: Coordinate
) {
    init {
        require(name.isNotBlank()) { "Name must not be blank" }
        require(address.isNotBlank()) { "Address must not be blank" }
    }
}