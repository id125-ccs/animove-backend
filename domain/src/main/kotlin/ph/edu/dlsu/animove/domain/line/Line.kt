package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.shared.Coordinate
import java.util.UUID
import kotlin.text.isNotBlank

/**
 * Represents a transit or shuttle line within the Animove system.
 *
 * Invariants:
 * - name must be trimmed
 * - name must not be blank
 * - name length must be at most 63 characters
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
 * - name must be trimmed
 * - name must not be blank
 * - name length must be at most 63 characters
 *
 * - address must be trimmed
 * - address must not be blank
 * - address length must be at most 127 characters
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
    companion object {
        const val MAX_NAME_LENGTH = 63
        const val MAX_ADDRESS_LENGTH = 127
    }
    init {
        val nameNormalized = name.trim()
        val addressNormalized = address.trim()

        require(nameNormalized.isNotBlank()) { "Name must not be blank" }
        require(addressNormalized.isNotBlank()) { "Address must not be blank" }

        require(nameNormalized.length <= MAX_NAME_LENGTH) { "Name must not exceed $MAX_NAME_LENGTH characters" }
        require(addressNormalized.length <= MAX_ADDRESS_LENGTH) { "Address must not exceed $MAX_ADDRESS_LENGTH characters" }
    }
}