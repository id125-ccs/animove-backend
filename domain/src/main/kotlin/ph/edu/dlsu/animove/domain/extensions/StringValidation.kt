package ph.edu.dlsu.animove.domain.extensions

import ph.edu.dlsu.animove.domain.error.ValidationError

class StringBlank : ValidationError("String must not be blank")
class StringExceedMaxLength(maxLength: Int) : ValidationError("String must not exceed $maxLength characters")

class StringValidationScope(
    private val value: String
) {
    fun notBlank() {
        if (value.isBlank())
            throw StringBlank()
    }

    fun maxLength(
        max: Int,
    ) {
        if (value.length > max) throw StringExceedMaxLength(max)
    }
}

internal fun String.validate(
    block: StringValidationScope.() -> Unit
) = StringValidationScope(this).block()