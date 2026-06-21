package ph.edu.dlsu.animove.domain.shared

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CoordinateTest : FunSpec({
    context("creation") {
        test("should create coordinate when latitude and longitude are valid") {
            val coordinate = Coordinate(
                latitude = 14.5995,
                longitude = 120.9842
            )

            coordinate.latitude shouldBe 14.5995
            coordinate.longitude shouldBe 120.9842
        }

        test("should allow minimum boundary values") {
            val coordinate = Coordinate(
                latitude = Coordinate.MINIMUM_LATITUDE,
                longitude = Coordinate.MINIMUM_LONGITUDE
            )

            coordinate.latitude shouldBe Coordinate.MINIMUM_LATITUDE
            coordinate.longitude shouldBe Coordinate.MINIMUM_LONGITUDE
        }

        test("should allow maximum boundary values") {
            val coordinate = Coordinate(
                latitude = Coordinate.MAXIMUM_LATITUDE,
                longitude = Coordinate.MAXIMUM_LONGITUDE
            )

            coordinate.latitude shouldBe Coordinate.MAXIMUM_LATITUDE
            coordinate.longitude shouldBe Coordinate.MAXIMUM_LONGITUDE
        }

        test("should throw when latitude is below minimum") {
            val exception = shouldThrow<LatitudeOutOfBounds> {
                Coordinate(
                    latitude = Coordinate.MINIMUM_LATITUDE - 0.1,
                    longitude = 0.0
                )
            }

            exception.message shouldBe
                    "Latitude must be between ${Coordinate.MINIMUM_LATITUDE} and ${Coordinate.MAXIMUM_LATITUDE}"
        }

        test("should throw when latitude is above maximum") {
            val exception = shouldThrow<LatitudeOutOfBounds> {
                Coordinate(
                    latitude = Coordinate.MAXIMUM_LATITUDE + 0.1,
                    longitude = 0.0
                )
            }

            exception.message shouldBe
                    "Latitude must be between ${Coordinate.MINIMUM_LATITUDE} and ${Coordinate.MAXIMUM_LATITUDE}"
        }

        test("should throw when longitude is below minimum") {
            val exception = shouldThrow<LongitudeOutOfBounds> {
                Coordinate(
                    latitude = 0.0,
                    longitude = Coordinate.MINIMUM_LONGITUDE - 0.1
                )
            }

            exception.message shouldBe
                    "Longitude must be between ${Coordinate.MINIMUM_LONGITUDE} and ${Coordinate.MAXIMUM_LONGITUDE}"
        }

        test("should throw when longitude is above maximum") {
            val exception = shouldThrow<LongitudeOutOfBounds> {
                Coordinate(
                    latitude = 0.0,
                    longitude = Coordinate.MAXIMUM_LONGITUDE + 0.1
                )
            }

            exception.message shouldBe
                    "Longitude must be between ${Coordinate.MINIMUM_LONGITUDE} and ${Coordinate.MAXIMUM_LONGITUDE}"
        }
    }
})