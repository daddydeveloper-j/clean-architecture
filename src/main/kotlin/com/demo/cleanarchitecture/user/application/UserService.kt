package com.demo.cleanarchitecture.user.application

import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService : UserQuery {
    private val users: Map<Long, User> = mapOf(
        1L to User(id = 1, name = "tester-1", email = "test@test.com", password = "123", age = 24),
        2L to User(id = 2, name = "tester-2", email = "test2@test.com", password = "1234", age = 26)
    )

    override fun getAllUsers(): List<UserResponse> = users.values.map { UserResponse.from(it) }

    override fun getUser(id: Long): UserResponse =
        users[id]?.let { UserResponse.from(it) } ?: throw RuntimeException("user not found")
}
