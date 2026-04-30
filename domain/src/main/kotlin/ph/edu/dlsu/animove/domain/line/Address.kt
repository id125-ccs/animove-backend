package ph.edu.dlsu.animove.domain.line

import ph.edu.dlsu.animove.domain.extensions.validate

/**
 * Creates an [Address] from a raw string.
 */
val String.domainAddress: Address
    get() = Address.create(this)

/**
 * Represents a free-form address string used within the system.
 *
 * The value is treated as user-provided location text.
 *
 * Invariants:
 * - Value is trimmed
 * - Must not be blank
 * - Maximum length is [MAX_LENGTH] characters
 */
@JvmInline
value class Address private constructor(val value: String) {
    companion object {
        private const val MAX_LENGTH = 127

        fun create(raw: String): Address {
            val normalized = raw.trim()

            normalized.validate("Address") {
                notBlank()
                maxLength(MAX_LENGTH)
            }

            return Address(normalized)
        }
    }
}