package com.demo.cleanarchitecture.user.adapter.out.persistence

import com.demo.cleanarchitecture.user.domain.User
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    name: String,
    email: String,
    password: String,
    age: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set
    var name: String = name
        protected set
    var email: String = email
        protected set
    var password: String = password
        protected set
    var age: Int = age
        protected set

    fun update(user: User) {
        this.name = user.name
        this.email = user.email
        this.password = user.password
        this.age = user.age
    }

    companion object {
        fun from(user: User): UserEntity =
            UserEntity(
                name = user.name,
                email = user.email,
                password = user.password,
                age = user.age
            )
    }
}
