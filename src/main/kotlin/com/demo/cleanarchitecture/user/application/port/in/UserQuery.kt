package com.demo.cleanarchitecture.user.application.port.`in`

import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse

interface UserQuery {
    fun getAllUsers(): List<UserResponse>
    fun getUser(id: Long): UserResponse
}
