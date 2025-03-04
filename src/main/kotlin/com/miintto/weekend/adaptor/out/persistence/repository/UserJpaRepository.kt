package com.miintto.weekend.adaptor.out.persistence.repository

import com.miintto.weekend.adaptor.out.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity?
}
