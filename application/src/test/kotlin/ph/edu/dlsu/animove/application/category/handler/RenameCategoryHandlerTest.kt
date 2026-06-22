package ph.edu.dlsu.animove.application.category.handler

import application.category.command.RenameCategoryCommand
import application.category.handler.RenameCategoryHandler
import application.category.handler.RenameCategoryResult
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.Runs
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import ph.edu.dlsu.animove.domain.category.Category
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import java.util.UUID

class RenameCategoryHandlerTest : FunSpec({
    val repository = mockk<CategoryRepository>()
    val handler = RenameCategoryHandler(repository)

    beforeTest {
        clearMocks(repository)
    }

    test("should rename category successfully") {
        val id = UUID.randomUUID()
        val category = mockk<Category>(relaxed = true)

        every { repository.findById(id) } returns category
        every { repository.save(category) } just Runs

        val result = handler.handle(
            RenameCategoryCommand(id, "New Name")
        )

        result shouldBe RenameCategoryResult.Success

        verify(exactly = 1) { repository.save(category) }
    }

    test("should return NotFound when category does not exist") {
        val id = UUID.randomUUID()

        every { repository.findById(id) } returns null

        val result = handler.handle(
            RenameCategoryCommand(id, "New Name")
        )

        result shouldBe RenameCategoryResult.NotFound
    }

    test("should return InternalError when repository throws on find") {
        val id = UUID.randomUUID()

        every { repository.findById(id) } throws RuntimeException("DB crash")

        val result = handler.handle(
            RenameCategoryCommand(id, "New Name")
        )

        result.shouldBeInstanceOf<RenameCategoryResult.InternalError>()
    }
})