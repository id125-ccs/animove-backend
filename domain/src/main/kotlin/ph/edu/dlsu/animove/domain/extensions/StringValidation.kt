package ph.edu.dlsu.animove.domain.extensions

sealed interface StringValidationResult {
    data object Success : StringValidationResult

    sealed interface Failure : StringValidationResult {
        data object Blank : Failure
        data class ExceedsMaxLength(val max: Int) : Failure
    }
}

class StringValidationScope(
    private val value: String
) {
    private val results = mutableListOf<StringValidationResult>()

    fun notBlank() {
        if (value.isBlank()) {
            results += StringValidationResult.Failure.Blank
        }
    }

    fun maxLength(max: Int) {
        if (value.length > max) {
            results += StringValidationResult.Failure.ExceedsMaxLength(max)
        }
    }

    fun result(): StringValidationResult =
        results.firstOrNull { it is StringValidationResult.Failure }
            ?: StringValidationResult.Success
}

internal fun String.validate(
    block: StringValidationScope.() -> Unit
): StringValidationResult =
    StringValidationScope(this).apply(block).result()
