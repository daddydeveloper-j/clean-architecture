package com.demo.cleanarchitecture.user.application

import com.demo.cleanarchitecture.user.application.port.`in`.UserCommand
import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UpsertUserRequest
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import com.demo.cleanarchitecture.user.application.port.out.UserCommandPort
import com.demo.cleanarchitecture.user.application.port.out.UserQueryPort
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userQueryPort: UserQueryPort,
    private val userCommandPort: UserCommandPort
) : UserQuery, UserCommand {
    private var userSequence: Long = 2
    private val users: MutableMap<Long, User> = mutableMapOf(
        1L to User(id = 1, name = "tester-1", email = "test@test.com", password = "123", age = 24),
        2L to User(id = 2, name = "tester-2", email = "test2@test.com", password = "1234", age = 26)
    )

    override fun getAllUsers(): List<UserResponse> = userQueryPort.findAll().map { UserResponse.from(it) }

    override fun getUser(id: Long): UserResponse = UserResponse.from(userQueryPort.findUserById(id))

    override fun registerUser(req: UpsertUserRequest): UserResponse =
        UserResponse.from(userCommandPort.save(req.toUser()))

    override fun updateUser(id: Long, req: UpsertUserRequest): UserResponse =
        UserResponse.from(userCommandPort.update(req.toUser(id)))
}
