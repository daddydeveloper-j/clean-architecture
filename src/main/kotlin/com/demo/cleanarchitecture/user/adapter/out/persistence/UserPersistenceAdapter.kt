package com.demo.cleanarchitecture.user.adapter.out.persistence

import com.demo.cleanarchitecture.user.application.port.out.UserCommandPort
import com.demo.cleanarchitecture.user.application.port.out.UserQueryPort
import com.demo.cleanarchitecture.user.domain.User
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrElse

@Transactional
@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository
) : UserQueryPort, UserCommandPort {
    @Transactional(readOnly = true)
    override fun findAll(): List<User> = userRepository.findAll().map { entity ->
        User(
            id = checkNotNull(entity.id),
            name = entity.name,
            email = entity.email,
            password = entity.password,
            age = entity.age
        )
    }

    @Transactional(readOnly = true)
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

    override fun save(user: User): User {
        val entity = userRepository.save(UserEntity.from(user))

        return User(
            id = checkNotNull(entity.id),
            name = entity.name,
            email = entity.email,
            password = entity.password,
            age = entity.age
        )
    }

    override fun update(user: User): User {
        val entity = userRepository.findById(checkNotNull(user.id)).getOrElse { throw RuntimeException("user not found") }
        entity.update(user)

        return User(
            id = checkNotNull(entity.id),
            name = entity.name,
            email = entity.email,
            password = entity.password,
            age = entity.age
        )
    }
}
