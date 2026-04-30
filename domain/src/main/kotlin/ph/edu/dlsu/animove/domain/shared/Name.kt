package ph.edu.dlsu.animove.domain.shared

import ph.edu.dlsu.animove.domain.extensions.validate

/**
 * Creates an [Name] from a raw string.
 */
val String.domainName: Name
    get() = Name.create(this)

/**
 * Represents a label for domain entities
 *
 * Invariants:
 * - Value is trimmed
 * - Must not be blank
 * - Maximum length is [MAX_LENGTH] characters
 */
@JvmInline
value class Name private constructor(val value: String) {
    companion object {
        const val MAX_LENGTH = 63

        fun create(raw: String): Name {
            val normalized = raw.trim()

            normalized.validate("Name") {
                notBlank()
                maxLength(MAX_LENGTH)
            }

            return Name(normalized)
        }
    }
}