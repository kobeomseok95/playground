package com.hello.kotlin.user.application.response

import com.hello.kotlin.user.domain.User

data class UserResponseDto private constructor(
    val id: Long,
    val name: String,
    val age: Int,
    val address: String,
) {
    companion object {
        fun of(user: User) = UserResponseDto(
            id = user.id!!,
            name = user.name,
            age = user.age,
            address = user.address
        )
    }
}
