package com.hello.kotlin.user.application.response

import com.hello.kotlin.user.domain.User

data class UserResponseDto(
    val id: Long,
    val name: String,
    val age: Int,
    val address: String,
) {
    constructor(user: User) : this(
        user.id!!,
        user.name,
        user.age,
        user.address
    )
}
