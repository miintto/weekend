package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.domain.Band
import com.miintto.weekend.domain.User

interface UserUseCase {
    fun findUserInfo(userId: Long): User

    fun findUserBand(userId: Long): List<Band>
}
