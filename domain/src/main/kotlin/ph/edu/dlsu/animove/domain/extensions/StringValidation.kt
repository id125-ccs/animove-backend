package ph.edu.dlsu.animove.domain.extensions

class StringValidationScope(
    private val field: String,
    private val value: String
) {
    fun notBlank(
        message: String = "$field must not be blank"
    ) = require(value.isNotBlank()) { message }

    fun maxLength(
        max: Int,
        message: String = "$field must not exceed $max characters"
    ) = require(value.length <= max) { message }
}

internal fun String.validate(
    field: String,
    block: StringValidationScope.() -> Unit
) = StringValidationScope(field, this).block()

