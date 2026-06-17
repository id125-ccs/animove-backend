package ph.edu.dlsu.animove.domain.line

import java.util.UUID

/*
 * Repository for accessing and persisting [Line] aggregates.
 */
interface LineRepository {
    /**
     * Returns a line by its ID, or null if not found.
     */
    fun findById(id: UUID): Line?

    /**
     * Saves a line.
     *
     * Creates a new record or updates an existing one with the same ID.
     */
    fun save(line: Line)

    /**
     * Deletes a line by ID.
     *
     * This operation is idempotent.
     */
    fun delete(id: UUID)
}