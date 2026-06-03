package ph.edu.dlsu.animove.domain.category

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ReservationCapacityTest : FunSpec({
    context("creation") {
        test("should create reservation capacity when value is valid") {
            val capacity = ReservationCapacity(10)

            capacity.value shouldBe 10
        }

        test("should create reservation capacity when value is at minimum") {
            val capacity = ReservationCapacity(
                ReservationCapacity.MINIMUM_RESERVATION_CAPACITY
            )

            capacity.value shouldBe
                    ReservationCapacity.MINIMUM_RESERVATION_CAPACITY
        }

        test("should throw when value is less than minimum") {
            val exception = shouldThrow<IllegalArgumentException> {
                ReservationCapacity(
                    ReservationCapacity.MINIMUM_RESERVATION_CAPACITY - 1
                )
            }

            exception.message shouldBe
                    "Reservation capacity must be at least ${ReservationCapacity.MINIMUM_RESERVATION_CAPACITY}"
        }
    }
})