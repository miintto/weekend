package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.Band

interface BandRepositoryPort {
    fun save(band: Band): Band

    fun findById(id: Long): Band?
}
