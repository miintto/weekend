package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.domain.Band

interface BandUseCase {
    fun findBandInfo(bandId: Long): Band
}
