package com.demo.cleanarchitecture.user.application.port.out

import com.demo.cleanarchitecture.user.domain.User

interface UserCommandPort {
    fun save(user: User): User
    fun update(user: User): User
}
