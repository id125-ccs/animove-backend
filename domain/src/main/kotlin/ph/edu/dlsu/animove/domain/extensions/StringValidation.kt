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

/**
 * Validates a string using the provided validation rules.
 *
 * Example:
 * ```
 * name.validate("name") {
 *     notBlank()
 *     maxLength(50)
 * }
 * ```
 *
 * @throws StringBlank if the string is blank and [StringValidationScope.notBlank] is used.
 * @throws StringExceedMaxLength if the string exceeds the specified maximum
 * length and [StringValidationScope.maxLength] is used.
 */
internal fun String.validate(
    block: StringValidationScope.() -> Unit
) = StringValidationScope(this).block()