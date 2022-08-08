package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {

    @Test
    fun saveUserTest() {

        // given
        val request = UserCreateRequest("고범석", null)

        // when
        userService.saveUser(request)

        // then
        val users = userRepository.findAll()
        assertThat(users.size).isEqualTo(1)
        assertThat(users[0].name).isEqualTo(request.name)
        assertThat(users[0].age).isNull()
    }
}
