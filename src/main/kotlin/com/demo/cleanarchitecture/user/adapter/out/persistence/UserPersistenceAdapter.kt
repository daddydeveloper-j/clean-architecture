package com.demo.cleanarchitecture.user.adapter.out.persistence

import com.demo.cleanarchitecture.user.application.port.out.UserQueryPort
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrElse

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserQueryPort {
    override fun findAll(): List<User> = userRepository.findAll().map { entity ->
        User(
            id = checkNotNull(entity.id),
            name = entity.name,
            email = entity.email,
            password = entity.password,
            age = entity.age
        )
    }

    override fun findUserById(id: Long): User =
        userRepository.findById(id).getOrElse { throw RuntimeException("user not found") }
            .let { entity ->
                User(
                    id = checkNotNull(entity.id),
                    name = entity.name,
                    email = entity.email,
                    password = entity.password,
                    age = entity.age
                )
            }
}
