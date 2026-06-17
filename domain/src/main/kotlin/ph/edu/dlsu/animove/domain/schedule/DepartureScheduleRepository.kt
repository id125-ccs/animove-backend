package ph.edu.dlsu.animove.domain.schedule

import java.util.UUID

/*
 * Repository for accessing and persisting [DepartureSchedule] aggregates.
 */
interface DepartureScheduleRepository {
    /**
     * Returns a departure schedule by its ID, or null if not found.
     */
    fun findById(id: UUID): DepartureSchedule?

    /**
     * Saves a departure schedule.
     *
     * Creates a new record or updates an existing one with the same ID.
     */
    fun save(departureSchedule: DepartureSchedule)

    /**
     * Deletes a departure schedule by ID.
     *
     * This operation is idempotent.
     */
    fun delete(id: UUID)
}