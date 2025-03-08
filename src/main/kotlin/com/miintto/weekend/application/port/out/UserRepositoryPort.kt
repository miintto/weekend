package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.User

interface UserRepositoryPort {
    fun save(user: User): User

    fun findById(userId: Long): User

    fun findByEmail(email: String): User?
}
