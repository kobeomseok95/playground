package com.hello.kotlin.user.service.dto.request

import com.hello.kotlin.user.domain.User

data class CreateUserRequestDto (
    val username: String,
    val password: String
) {
    fun from(): User {
        return User (
            username = username,
            password = password
        )
    }
}
