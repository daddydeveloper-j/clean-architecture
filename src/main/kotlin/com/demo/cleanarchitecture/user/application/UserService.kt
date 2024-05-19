package com.demo.cleanarchitecture.user.application

import com.demo.cleanarchitecture.user.application.port.`in`.UserCommand
import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UpsertUserRequest
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import com.demo.cleanarchitecture.user.application.port.out.UserCommandPort
import com.demo.cleanarchitecture.user.application.port.out.UserQueryPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userQueryPort: UserQueryPort,
    private val userCommandPort: UserCommandPort
) : UserQuery, UserCommand {
    override fun getAllUsers(): List<UserResponse> = userQueryPort.findAll().map { UserResponse.from(it) }

    override fun getUser(id: Long): UserResponse = UserResponse.from(userQueryPort.findUserById(id))

    override fun registerUser(req: UpsertUserRequest): UserResponse =
        UserResponse.from(userCommandPort.save(req.toUser()))

    override fun updateUser(id: Long, req: UpsertUserRequest): UserResponse =
        UserResponse.from(userCommandPort.update(req.toUser(id)))
}
