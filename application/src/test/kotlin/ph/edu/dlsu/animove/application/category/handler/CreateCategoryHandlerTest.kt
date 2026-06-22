package ph.edu.dlsu.animove.application.category.handler

import application.category.command.CreateCategoryCommand
import application.category.handler.CreateCategoryHandler
import application.category.handler.CreateCategoryResult
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.*
import ph.edu.dlsu.animove.domain.category.CategoryRepository
import ph.edu.dlsu.animove.domain.error.ValidationError
import java.util.UUID

class CreateCategoryHandlerTest : FunSpec({
    val repository = mockk<CategoryRepository>()
    val fixedId = UUID.randomUUID()

    val handler = CreateCategoryHandler(repository) { fixedId }

    beforeTest {
        clearMocks(repository)
    }

    test("should create category successfully") {
        val command = CreateCategoryCommand("Food", 10)

        every { repository.save(any()) } just Runs

        val result = handler.handle(command)

        result shouldBe CreateCategoryResult.Success(fixedId)

        verify(exactly = 1) { repository.save(any()) }
    }

    test("should return ValidationFailed when domain error occurs") {
        val command = CreateCategoryCommand("", 10)

        every { repository.save(any()) } throws ValidationError("")

        val result = handler.handle(command)

        result.shouldBeInstanceOf<CreateCategoryResult.ValidationFailed>()
    }

    test("should return InternalError when unexpected exception occurs") {
        every { repository.save(any()) } throws RuntimeException("DB down")

        val result = handler.handle(
            CreateCategoryCommand("Food", 10)
        )

        result.shouldBeInstanceOf<CreateCategoryResult.InternalError>()
    }
})