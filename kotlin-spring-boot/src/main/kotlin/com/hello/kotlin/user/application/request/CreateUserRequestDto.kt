package com.hello.kotlin.user.application.request

import com.hello.kotlin.user.domain.User

data class CreateUserRequestDto (
    val name: String,
    val age: Int,
    val address: String,
) {
    fun toEntity() = User(
        name,
        age,
        address
    )
}