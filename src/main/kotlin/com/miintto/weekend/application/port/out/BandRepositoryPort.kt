package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.Band

interface BandRepositoryPort {
    fun findById(id: Long): Band?
}
