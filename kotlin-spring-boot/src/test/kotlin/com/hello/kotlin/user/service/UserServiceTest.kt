package com.hello.kotlin.user.service

import com.hello.kotlin.user.domain.UserRepository
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class UserServiceTest {

    @MockkBean
    private lateinit var userRepository: UserRepository

    @Test
    fun `유저 생성 성공`() {

    }
}