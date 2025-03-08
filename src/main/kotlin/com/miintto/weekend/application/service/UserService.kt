package com.miintto.weekend.application.service

import com.miintto.weekend.application.port.`in`.UserUseCase
import com.miintto.weekend.application.port.out.BandUserRepositoryPort
import com.miintto.weekend.application.port.out.UserRepositoryPort
import com.miintto.weekend.domain.Band
import com.miintto.weekend.domain.User
import org.springframework.stereotype.Service

@Service
class UserService(
    val bandUserRepository: BandUserRepositoryPort,
    val userRepositoryPort: UserRepositoryPort,
) : UserUseCase {
    override fun findUserInfo(userId: Long): User {
        return userRepositoryPort.findById(userId)
    }

    override fun findUserBand(userId: Long): List<Band> {
        return bandUserRepository.findUserBand(userId)
    }
}
