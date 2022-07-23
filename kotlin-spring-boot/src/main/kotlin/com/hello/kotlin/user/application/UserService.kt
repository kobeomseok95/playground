package com.hello.kotlin.user.application

import com.hello.kotlin.user.application.request.CreateUserRequestDto
import com.hello.kotlin.user.application.response.UserResponseDto
import com.hello.kotlin.user.domain.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserUseCase {
    fun findById(id: Long): UserResponseDto
    fun save(createUserRequestDto: CreateUserRequestDto): UserResponseDto
}

@Service
@Transactional
internal class UserService(
    private val userRepository: UserRepository,
): UserUseCase {

    override fun findById(id: Long) =
        UserResponseDto(
            userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("유저를 찾을 수 없습니다.")
        )


    @Transactional(readOnly = true)
    override fun save(createUserRequestDto: CreateUserRequestDto) =
        UserResponseDto(
            userRepository.save(createUserRequestDto.toEntity())
        )
}