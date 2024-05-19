package com.demo.cleanarchitecture.user.application.port.`in`.dto

import com.demo.cleanarchitecture.user.domain.User

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val age: Int
) {

    companion object {
        fun from(user: User) =
            UserResponse(
                id = checkNotNull(user.id),
                name = user.name,
                email = user.email,
                password = user.password,
                age = user.age
            )
    }
}
