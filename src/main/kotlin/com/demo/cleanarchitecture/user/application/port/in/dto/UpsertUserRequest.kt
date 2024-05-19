package com.demo.cleanarchitecture.user.application.port.`in`.dto

import com.demo.cleanarchitecture.user.domain.User

data class UpsertUserRequest(
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
    val age: Int
) {
    fun toUser(): User = User(name = name, email = email, password = password, age = age)
    fun toUser(id: Long): User = User(id = id, name = name, email = email, password = password, age = age)
}
