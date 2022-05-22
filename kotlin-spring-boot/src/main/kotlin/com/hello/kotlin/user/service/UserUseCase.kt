package com.hello.kotlin.user.service

import com.hello.kotlin.user.service.dto.request.CreateUserRequestDto

interface UserUseCase {

    fun save(createUserRequestDto: CreateUserRequestDto)
}