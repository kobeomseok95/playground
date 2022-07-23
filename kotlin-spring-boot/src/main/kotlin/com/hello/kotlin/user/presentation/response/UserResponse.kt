package com.hello.kotlin.user.presentation.response

import com.hello.kotlin.user.application.response.UserResponseDto

class UserResponse(
    val id: Long,
    val name: String,
    val age: Int,
    val address: String,
) {
    companion object {
        fun from(responseDto: UserResponseDto) : UserResponse =
            UserResponse(responseDto.id,
                responseDto.name,
                responseDto.age,
                responseDto.address
            )
    }
}
