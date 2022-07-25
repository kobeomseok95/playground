package com.hello.kotlin.user.application.request

import com.hello.kotlin.user.domain.User

data class UserRequestDto (
    val name: String,
    val age: Int,
    val address: String,
) {

    fun toEntity() = User(
        name = name,
        age = age,
        address = address
    )
}