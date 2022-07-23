package com.hello.kotlin.user.presentation

import com.hello.kotlin.user.application.UserUseCase
import com.hello.kotlin.user.presentation.request.CreateUserRequest
import com.hello.kotlin.user.presentation.response.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserRestController(
    val userUseCase: UserUseCase
) {

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long) =
        UserResponse.from(userUseCase.findById(userId))

    @PostMapping("")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest) =
        UserResponse.from(userUseCase.save(createUserRequest.toRequestDto()))
}