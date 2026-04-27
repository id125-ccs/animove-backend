package ph.edu.dlsu.animove.domain

import org.junit.jupiter.api.Assertions.assertThrows
import ph.edu.dlsu.animove.domain.category.Category
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals

class CategoryTest {

    @Test
    fun `should create category with valid inputs`() {
        val category = Category(
            id = UUID.randomUUID(),
            name = "Bus",
            reservationCapacity = 10
        )

        assertEquals("Bus", category.name)
        assertEquals(10, category.reservationCapacity)
    }

    @Test
    fun `should throw when name is blank`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Category(
                id = UUID.randomUUID(),
                name = "   ",
                reservationCapacity = 10
            )
        }

        assertEquals("Name must not be blank", exception.message)
    }

    @Test
    fun `should throw when reservationCapacity is zero or negative`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Category(
                id = UUID.randomUUID(),
                name = "Bus",
                reservationCapacity = 0
            )
        }

        assertEquals("Reservation capacity must be greater than 0", exception.message)
    }
}