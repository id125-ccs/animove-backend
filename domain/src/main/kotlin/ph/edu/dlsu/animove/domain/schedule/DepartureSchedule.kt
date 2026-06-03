package ph.edu.dlsu.animove.domain.schedule

import ph.edu.dlsu.animove.domain.line.Direction
import ph.edu.dlsu.animove.domain.line.Line
import java.util.UUID
import kotlin.time.Instant

/**
 * Represents a scheduled departure of a line in a specific direction.
 *
 * A departure schedule defines the exact time at which a line is expected
 * to depart and the direction in which the trip will operate.
 *
 * @property id Unique identifier of the departure schedule.
 * @property line Line assigned to the scheduled departure.
 * @property direction Direction of travel for the departure.
 * @property departureTime Exact scheduled departure time.
 */
class DepartureSchedule(
    val id: UUID,
    val line: Line,
    val direction: Direction,
    val departureTime: Instant,
)