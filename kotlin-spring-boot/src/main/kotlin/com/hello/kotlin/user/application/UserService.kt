package com.hello.kotlin.user.application

import com.hello.kotlin.user.application.request.UserRequestDto
import com.hello.kotlin.user.application.response.UserResponseDto
import com.hello.kotlin.user.domain.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserUseCase {
    fun findById(id: Long): UserResponseDto
    fun save(userRequestDto: UserRequestDto): UserResponseDto
    fun updateUser(id: Long, toRequestDto: UserRequestDto): UserResponseDto
}

@Service
@Transactional
internal class UserService(
    private val userRepository: UserRepository,
): UserUseCase {

    override fun findById(id: Long) = UserResponseDto.of(
            userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("유저를 찾을 수 없습니다.")
        )

    @Transactional(readOnly = true)
    override fun save(userRequestDto: UserRequestDto) = UserResponseDto.of(
            userRepository.save(userRequestDto.toEntity())
        )

    override fun updateUser(id: Long, requestDto: UserRequestDto): UserResponseDto {
        val user = userRepository.findByIdOrNull(id)
            ?: throw java.lang.IllegalArgumentException("유저를 찾을 수 없습니다.")
        user.updateInfo(
            requestDto.name,
            requestDto.age,
            requestDto.address
        )
        return UserResponseDto.of(user)
    }
}
