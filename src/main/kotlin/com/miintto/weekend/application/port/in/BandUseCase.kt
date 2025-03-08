package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.application.command.BandCreateCommand
import com.miintto.weekend.domain.Band

interface BandUseCase {
    fun createBand(command: BandCreateCommand, userId: Long): Band

    fun findBandInfo(bandId: Long): Band
}
