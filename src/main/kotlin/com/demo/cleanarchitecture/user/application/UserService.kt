package com.demo.cleanarchitecture.user.application

import com.demo.cleanarchitecture.user.application.port.`in`.UserQuery
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Service

@Service
class UserService : UserQuery {
    override fun getAllUsers(): List<User> = listOf(
        User(
            id = 1,
            name = "tester-1",
            email = "test@test.com",
            password = "123",
            age = 24
        ),
        User(
            id = 2,
            name = "tester-2",
            email = "test2@test.com",
            password = "1234",
            age = 26
        ),
    )

    override fun getUser(id: Long): User? = User(
        id = id,
        name = "tester-$id",
        email = "test-$id@test.com",
        password = "123",
        age = 24
    )
}
