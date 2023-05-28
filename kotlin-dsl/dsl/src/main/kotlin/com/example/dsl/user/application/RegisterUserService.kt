package com.example.dsl.user.application

import com.example.dsl.user.application.port.`in`.RegisterUser
import com.example.dsl.user.application.port.`in`.RegisterUserCommand
import com.example.dsl.user.domain.User
import org.springframework.stereotype.Service

@Service
internal class RegisterUserService(

) : RegisterUser {
    override fun registerUser(command: RegisterUserCommand): User {
        TODO("Not yet implemented")
    }
}
