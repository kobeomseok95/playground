package com.example.dsl.user.adapter.`in`.web

import com.example.dsl.common.adapter.`in`.web.WebMvcTestSupport
import com.example.dsl.user.application.port.`in`.RegisterUserCommand
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpMethod

@WebMvcTest(RegisterUserController::class)
internal class RegisterUserControllerTest : WebMvcTestSupport() {

    @Test
    fun `유저를 등록한다`() {
        httpTest {
            request {
                method = HttpMethod.POST
                path = "/api/v1/user"
                header("Content-Type", "application/json")
                body = objectMapper.writeValueAsString(createRegisterUserCommand())
            }
        }
    }

    private fun createRegisterUserCommand(): RegisterUserCommand = RegisterUserCommand(
        name = "test",
        nickname = "test",
        email = "test@test.com",
        password = "test",
    )
}