package com.hello.kotlin.user.application.service

import com.hello.kotlin.user.application.service.response.UserResponseDto
import org.springframework.stereotype.Service

interface GetUserUseCase {

    fun findById(id: Long): UserResponseDto
}

@Service
internal class GetUserService: GetUserUseCase {

    override fun findById(id: Long): UserResponseDto {
        return UserResponseDto(1L, "고범석", 28)
    }
}