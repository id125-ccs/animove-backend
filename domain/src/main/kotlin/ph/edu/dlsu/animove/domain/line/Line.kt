package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.shared.Name
import java.util.UUID

/**
 * Represents a transit or shuttle line within the system.
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
    var name: Name,
)