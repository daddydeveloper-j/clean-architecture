package com.demo.cleanarchitecture.user.application.port.out

import com.demo.cleanarchitecture.user.domain.User

interface UserQueryPort {
    fun findAll(): List<User>
    fun findUserById(id: Long): User
}
