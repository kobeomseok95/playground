package com.hello.kotlin.user.service

import com.hello.kotlin.user.domain.UserRepository
import com.hello.kotlin.user.service.dto.request.CreateUserRequestDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService (
    private val userRepository: UserRepository
) : UserUseCase {
    override fun save(createUserRequestDto: CreateUserRequestDto) {

    }
}