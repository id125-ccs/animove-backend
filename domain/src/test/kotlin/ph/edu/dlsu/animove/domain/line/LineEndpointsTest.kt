package ph.edu.dlsu.animove.domain.line

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import ph.edu.dlsu.animove.domain.shared.Coordinate
import ph.edu.dlsu.animove.domain.shared.domainName

class LineEndpointsTest : FunSpec({
    context("creation") {
        test("should create line endpoints when locations are distinct") {
            val endpoints = LineEndpoints(
                a = Endpoint("Manila".domainName, "Manila".domainAddress, Coordinate(0.0, 0.0)),
                b = Endpoint("Laguna".domainName, "Laguna".domainAddress, Coordinate(0.0, 0.0)),
            )

            endpoints.a shouldNotBe endpoints.b
        }

        test("should throw when locations are identical") {
            val endpoint = Endpoint("Manila".domainName, "Manila".domainAddress, Coordinate(0.0, 0.0))

            val exception = shouldThrow<IllegalArgumentException> {
                LineEndpoints(
                    a = endpoint,
                    b = endpoint
                )
            }

            exception.message shouldBe
                    "Line endpoints must be distinct locations"
        }
    }
})