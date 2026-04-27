package ph.edu.dlsu.animove.domain.category

import java.util.UUID

/**
 * Repository interface for managing the persistence of [Category] entities.
 */
interface ICategoryRepository {
    /**
     * Returns all categories.
     */
    fun findAll(): List<Category>

    /**
     * Retrieves a category by its unique identifier.
     *
     * @param id The [UUID] of the category to find.
     * @return The found [Category] instance, or `null` if no category
     * exists with the provided [id].
     */
    fun findById(id: UUID): Category?

    /**
     * Persists a given category entity.
     * If the entity already exists (based on its unique identifier), this method
     * will update the existing record. If it does not exist, a new record is created.
     *
     * @param category The [Category] instance to be saved or updated.
     */
    fun save(category: Category)

    /**
     * Deletes the category associated with the specified identifier.
     * If no category is found with the given [id], the operation will
     * complete without an exception (idempotent).
     *
     * @param id The [UUID] of the category to be removed.
     */
    fun delete(id: UUID)
}