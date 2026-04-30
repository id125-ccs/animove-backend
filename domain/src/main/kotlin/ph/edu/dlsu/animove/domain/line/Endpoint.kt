package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.shared.Coordinate
import ph.edu.dlsu.animove.domain.shared.Name

/**
 * Represents a named location in the system.
 *
 * @property name Identifier for the location.
 * @property address Free-form human-readable address.
 * @property coordinate Geographic position.
 */
data class Endpoint(
    val name: Name,
    val address: Address,
    val coordinate: Coordinate
)