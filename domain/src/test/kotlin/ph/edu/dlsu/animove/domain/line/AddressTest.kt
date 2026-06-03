package ph.edu.dlsu.animove.domain.line

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AddressTest : FunSpec({
    context("creation") {
        test("should create address when value is valid") {
            val address = "123 Main Street".domainAddress

            address.value shouldBe "123 Main Street"
        }

        test("should trim leading and trailing whitespace") {
            val address = "  123 Main Street  ".domainAddress

            address.value shouldBe "123 Main Street"
        }

        test("should throw when address is blank") {
            val exception = shouldThrow<IllegalArgumentException> {
                "   ".domainAddress
            }

            exception.message shouldBe "Address must not be blank"
        }

        test("should throw when address exceeds maximum length") {
            val exception = shouldThrow<IllegalArgumentException> {
                "a".repeat(128).domainAddress
            }

            exception.message shouldBe "Address must not exceed 127 characters"
        }

        test("should allow address at maximum length") {
            val address = "a".repeat(127).domainAddress

            address.value.length shouldBe 127
        }
    }
})