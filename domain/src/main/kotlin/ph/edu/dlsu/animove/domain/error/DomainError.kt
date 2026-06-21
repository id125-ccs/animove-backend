package ph.edu.dlsu.animove.domain.error

sealed class DomainError(message: String) : RuntimeException(message)

open class ValidationError(message: String) : DomainError(message)

class UnexpectedError(cause: Throwable) : RuntimeException(cause)