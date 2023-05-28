package com.example.dsl.user.adapter.`in`.web

import com.example.dsl.common.adapter.`in`.web.ConvertCommand
import com.example.dsl.user.application.port.`in`.RegisterUser
import com.example.dsl.user.application.port.`in`.RegisterUserCommand
import com.example.dsl.user.domain.User
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterUserController(
    private val registerUser: RegisterUser,
) {
    @PostMapping("/api/v1/user")
    fun registerUser(@Valid request: RegisterUserRequest): ResponseEntity<RegisterUserResponse> =
        registerUser.registerUser(request.toCommand())
            .let { ResponseEntity.ok().body(RegisterUserResponse.of(it)) }
}

data class RegisterUserRequest(
    @NotBlank
    val name: String,
    @Length(min = 8, max = 20)
    val nickname: String,
    @Email
    val email: String,
    @Length(min = 8, max = 20)
    val password: String,
) : ConvertCommand<RegisterUserCommand> {
    override fun toCommand(): RegisterUserCommand = RegisterUserCommand(
        name = name,
        nickname = nickname,
        email = email,
        password = password,
    )
}

data class RegisterUserResponse(
    val id: Long,
    val name: String,
    val nickname: String,
    val email: String,
) {
    companion object {
        fun of(user: User): RegisterUserResponse = with(user) {
            RegisterUserResponse(
                id = requireNotNull(id?.id),
                name = name,
                nickname = nickname,
                email = email,
            )
        }
    }
}
