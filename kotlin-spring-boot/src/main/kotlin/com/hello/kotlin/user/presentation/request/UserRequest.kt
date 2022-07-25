package com.hello.kotlin.user.presentation.request

import com.hello.kotlin.user.application.request.UserRequestDto

data class UserRequest(
    val name: String,
    val age: Int,
    val address: String,
) {

    fun toRequestDto() = UserRequestDto(
        name = name,
        age = age,
        address = address
    )
}