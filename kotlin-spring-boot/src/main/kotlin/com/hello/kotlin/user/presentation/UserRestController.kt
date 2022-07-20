package com.hello.kotlin.user.presentation

import com.hello.kotlin.user.application.service.GetUserUseCase
import com.hello.kotlin.user.presentation.response.UserResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserRestController(
    val getUserUseCase: GetUserUseCase
) {

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long) : UserResponse =
        UserResponse.from(getUserUseCase.findById(userId))
}