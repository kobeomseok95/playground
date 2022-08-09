package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {

    @AfterEach
    fun tearDown() {
        userRepository.deleteAll()
    }

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

    @Test
    fun getUsersTest() {

        // given
        userRepository.saveAll(listOf(
            User("A", 20),
            User("B", null),
        ))

        // when
        val results = userService.getUsers()

        // then
        assertThat(results).hasSize(2)
        assertThat(results).extracting("name")
            .containsExactlyInAnyOrder("A", "B")
    }

    @Test
    fun updateUserNameTest() {

        // given
        val savedUser = userRepository.save(User("A", null))
        val request = UserUpdateRequest(savedUser.id, "B")

        // when
        userService.updateUserName(request)

        // then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo(request.name)
    }

    @Test
    fun deleteUserTest() {

        // given
        val savedUser = userRepository.save(User("A", null))

        // when
        userService.deleteUser("A")

        // then
        assertThat(userRepository.findAll()).isEmpty()
    }
}
