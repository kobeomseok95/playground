package com.hello.kotlin.user.presentation.request

import com.hello.kotlin.user.application.request.CreateUserRequestDto

data class CreateUserRequest(
    val name: String,
    val age: Int,
    val address: String,
) {

    fun toRequestDto() = CreateUserRequestDto(
        name,
        age,
        address
    )
}