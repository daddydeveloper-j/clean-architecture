package com.demo.cleanarchitecture.user.application

import com.demo.cleanarchitecture.user.application.port.`in`.UserCommand
import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UpsertUserRequest
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService : UserQuery, UserCommand {
    private var userSequence: Long = 2
    private val users: MutableMap<Long, User> = mutableMapOf(
        1L to User(id = 1, name = "tester-1", email = "test@test.com", password = "123", age = 24),
        2L to User(id = 2, name = "tester-2", email = "test2@test.com", password = "1234", age = 26)
    )

    override fun getAllUsers(): List<UserResponse> = users.values.map { UserResponse.from(it) }

    override fun getUser(id: Long): UserResponse =
        users[id]?.let { UserResponse.from(it) } ?: throw RuntimeException("user not found")

    override fun registerUser(req: UpsertUserRequest): UserResponse {
        val user = User(
            id = ++userSequence,
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )
        users[user.id] = user

        return UserResponse.from(user)
    }


    override fun updateUser(id: Long, req: UpsertUserRequest): UserResponse {
        val user = users[id] ?: throw RuntimeException("user not found")
        val updatedUser = user.copy(
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )
        users[id] = updatedUser
        return UserResponse.from(updatedUser)
    }
}
