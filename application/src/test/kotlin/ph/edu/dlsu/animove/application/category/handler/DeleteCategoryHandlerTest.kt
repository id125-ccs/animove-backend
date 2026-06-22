package ph.edu.dlsu.animove.application.category.handler

import application.category.command.DeleteCategoryCommand
import application.category.handler.DeleteCategoryHandler
import application.category.handler.DeleteCategoryResult
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.Runs
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import java.util.UUID

class DeleteCategoryHandlerTest : FunSpec({
    val repository = mockk<CategoryRepository>()
    val handler = DeleteCategoryHandler(repository)

    beforeTest {
        clearMocks(repository)
    }

    test("should delete category successfully") {
        val id = UUID.randomUUID()

        every { repository.delete(id) } just Runs

        val result = handler.handle(DeleteCategoryCommand(id))

        result shouldBe DeleteCategoryResult.Success

        verify(exactly = 1) { repository.delete(id) }
    }

    test("should return InternalError when repository throws") {
        val id = UUID.randomUUID()

        every { repository.delete(id) } throws RuntimeException("DB error")

        val result = handler.handle(DeleteCategoryCommand(id))

        result.shouldBeInstanceOf<DeleteCategoryResult.InternalError>()
    }
})