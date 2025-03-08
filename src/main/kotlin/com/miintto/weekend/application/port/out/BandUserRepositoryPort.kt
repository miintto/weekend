package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.Band
import com.miintto.weekend.domain.BandUser

interface BandUserRepositoryPort {
    fun save(bandUser: BandUser): BandUser

    fun findUserBand(userId: Long): List<Band>
}
