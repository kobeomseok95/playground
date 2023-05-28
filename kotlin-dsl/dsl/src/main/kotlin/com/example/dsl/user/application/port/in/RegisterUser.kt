package com.example.dsl.user.application.port.`in`

import com.example.dsl.user.domain.User

interface RegisterUser {
    fun registerUser(command: RegisterUserCommand): User
}

data class RegisterUserCommand(
    val name: String,
    val nickname: String,
    val email: String,
    val password: String,
)
