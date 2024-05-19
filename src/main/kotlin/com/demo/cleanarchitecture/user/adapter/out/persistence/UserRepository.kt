package com.demo.cleanarchitecture.user.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long>
