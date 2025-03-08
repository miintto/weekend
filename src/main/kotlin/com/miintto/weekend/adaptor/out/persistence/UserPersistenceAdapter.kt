package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.adaptor.out.persistence.entity.UserEntity
import com.miintto.weekend.adaptor.out.persistence.repository.UserJpaRepository
import com.miintto.weekend.application.port.out.UserRepositoryPort
import com.miintto.weekend.domain.User
import com.miintto.weekend.global.exception.ApiException
import com.miintto.weekend.global.response.http.Http4xx
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
) : UserRepositoryPort {
    override fun save(user: User): User {
        return userJpaRepository.save(UserEntity.fromDomain(user)).toDomain()
    }

    override fun findById(userId: Long): User {
        val user = userJpaRepository.findByIdOrNull(userId) ?: throw ApiException(Http4xx.USER_NOT_FOUND)
        return user.toDomain()
    }

    override fun findByEmail(email: String): User? {
        return userJpaRepository.findByEmail(email)?.toDomain()
    }
}
