package com.demo.cleanarchitecture.user.adapter.`in`.web

import com.demo.cleanarchitecture.user.application.port.`in`.UserCommand
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UpsertUserRequest
import com.demo.cleanarchitecture.user.application.port.`in`.dto.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RequestMapping("/users")
@RestController
class UserCommandController(
    private val userCommand: UserCommand
) {
    @PostMapping
    fun registerUser(@RequestBody req: UpsertUserRequest):ResponseEntity<UserResponse> =
        userCommand.registerUser(req).let {response ->
            ResponseEntity.created(URI.create("/users/${response.id}")).body(response)
        }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody req: UpsertUserRequest) = userCommand.updateUser(id, req)
}
