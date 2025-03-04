package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.adaptor.out.persistence.entity.UserEntity
import com.miintto.weekend.adaptor.out.persistence.repository.UserJpaRepository
import com.miintto.weekend.application.port.out.UserRepositoryPort
import com.miintto.weekend.domain.User
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
) : UserRepositoryPort {
    override fun save(user: User): User {
        return userJpaRepository.save(UserEntity.fromDomain(user)).toDomain()
    }

    override fun findByEmail(email: String): User? {
        return userJpaRepository.findByEmail(email)?.toDomain()
    }
}
