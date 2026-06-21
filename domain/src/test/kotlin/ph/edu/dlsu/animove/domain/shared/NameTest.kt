package ph.edu.dlsu.animove.domain.shared

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import ph.edu.dlsu.animove.domain.extensions.StringBlank
import ph.edu.dlsu.animove.domain.extensions.StringExceedMaxLength

class NameTest : FunSpec({
    context("creation") {
        test("should create name when value is valid") {
            val name = "Bus".domainName

            name.value shouldBe "Bus"
        }

        test("should trim leading and trailing spaces") {
            val name = "  Bus  ".domainName

            name.value shouldBe "Bus"
        }

        test("should throw when name is blank") {
            val exception = shouldThrow<StringBlank> {
                "   ".domainName
            }

            exception.message shouldBe "String must not be blank"
        }

        test("should throw when name exceeds maximum length") {
            val exception = shouldThrow<StringExceedMaxLength> {
                "a".repeat(Name.MAX_LENGTH + 1).domainName
            }

            exception.message shouldBe
                    "String must not exceed ${Name.MAX_LENGTH} characters"
        }

        test("should allow name at maximum length") {
            val name = "a".repeat(Name.MAX_LENGTH).domainName

            name.value.length shouldBe Name.MAX_LENGTH
        }
    }
})