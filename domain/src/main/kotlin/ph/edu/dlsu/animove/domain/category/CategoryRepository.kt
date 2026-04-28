package ph.edu.dlsu.animove.domain.category

import java.util.UUID

/**
 * Repository for accessing and persisting [Category] entities.
 */
interface CategoryRepository {

    /** Returns all categories. */
    fun findAll(): List<Category>

    /**
     * Returns a category by its ID, or null if not found.
     */
    fun findById(id: UUID): Category?

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