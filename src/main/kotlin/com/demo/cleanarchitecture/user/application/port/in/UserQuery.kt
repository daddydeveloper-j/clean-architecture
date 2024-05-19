package com.demo.cleanarchitecture.user.application.port.`in`

import com.demo.cleanarchitecture.user.domain.User

interface UserQuery {
    fun getAllUsers(): List<User>
    fun getUser(id: Long): User?
}
