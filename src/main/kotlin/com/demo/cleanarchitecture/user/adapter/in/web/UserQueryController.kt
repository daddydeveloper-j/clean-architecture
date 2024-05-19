package com.demo.cleanarchitecture.user.adapter.`in`.web

import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserQueryController(
    private val userQuery: UserQuery
) {
    @GetMapping
    fun getAllUsers(): List<UserResponse> = userQuery.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): UserResponse = userQuery.getUser(id)
}
