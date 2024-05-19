package com.demo.cleanarchitecture.user.application.port.`in`

import com.demo.cleanarchitecture.user.application.port.`in`.dto.UpsertUserRequest
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse

interface UserCommand {
    fun registerUser(req: UpsertUserRequest): UserResponse
    fun updateUser(id: Long, req: UpsertUserRequest): UserResponse
}
