package com.demo.cleanarchitecture.user.adapter.out.persistence

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

    fun update(name: String, email: String, password: String, age: Int) {
        this.name = name
        this.email = email
        this.password = password
        this.age = age
    }
}
