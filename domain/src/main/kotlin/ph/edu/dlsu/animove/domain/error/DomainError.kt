package ph.edu.dlsu.animove.domain.error

/**
 * Base type for all domain-level exceptions.
 *
 * Domain errors represent violations of business rules and invariants
 * within the domain model.
 */
sealed class DomainError(message: String) : RuntimeException(message)

/**
 * Represents a domain error caused by invalid input or a violated
 * domain invariant.
 */
open class ValidationError(message: String) : DomainError(message)

/**
 * Wraps an unexpected exception originating outside the domain layer.
 *
 * This error is used when an exception cannot be represented by a
 * domain-specific error type.
 */
class UnexpectedError(cause: Throwable) : RuntimeException(cause)