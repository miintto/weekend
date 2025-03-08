package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.BandUser

interface BandUserRepositoryPort {
    fun save(bandUser: BandUser): BandUser
}
