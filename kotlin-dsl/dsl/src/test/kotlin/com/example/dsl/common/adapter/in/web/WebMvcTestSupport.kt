package com.example.dsl.common.adapter.`in`.web

import com.example.dsl.user.adapter.`in`.web.RegisterUserController
import com.example.dsl.user.application.port.`in`.RegisterUser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@WebMvcTest(value = [
    RegisterUserController::class,
])
abstract class WebMvcTestSupport {
    @Autowired protected lateinit var objectMapper: ObjectMapper
    @Autowired private lateinit var mockMvc: MockMvc

    @MockBean private lateinit var registerUser: RegisterUser

    protected fun httpTest(init: HttpTestDSL.() -> Unit) {
        val test = HttpTestDSL()
        test.init()

        for (request in test.requests) {
            val result = mockMvc.perform(
                request(request.method, request.path)
                    .headers(request.headers)
                    .content(request.body ?: "")
            )
        }
    }
}
