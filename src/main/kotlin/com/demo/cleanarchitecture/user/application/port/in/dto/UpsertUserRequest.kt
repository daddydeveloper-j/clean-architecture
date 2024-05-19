package com.demo.cleanarchitecture.user.application.port.`in`.dto

data class UpsertUserRequest(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val age: Int
)
