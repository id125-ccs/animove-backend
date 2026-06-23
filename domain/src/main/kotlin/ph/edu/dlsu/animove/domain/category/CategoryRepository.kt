package ph.edu.dlsu.animove.domain.category

import ph.edu.dlsu.animove.domain.shared.Name
import java.util.UUID

/**
 * Repository for accessing and persisting [Category] entities.
 */
interface CategoryRepository {
    /**
     * Returns a category by its ID, or null if not found.
     */
    fun findById(id: UUID): Category?

    /**
     * Returns true if a category with the given [name] exists, or false if not.
     */
    fun existsByName(name: Name): Boolean

    /**
     * Saves a category.
     *
     * Creates a new record or updates an existing one with the same ID.
     */
    fun save(category: Category)

    /**
     * Deletes a category by ID.
     *
     * This operation is idempotent.
     */
    fun delete(id: UUID)
}