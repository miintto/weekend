package com.miintto.weekend.application.service

import com.miintto.weekend.application.command.BandCreateCommand
import com.miintto.weekend.application.port.`in`.BandUseCase
import com.miintto.weekend.application.port.out.BandRepositoryPort
import com.miintto.weekend.application.port.out.BandUserRepositoryPort
import com.miintto.weekend.domain.Band
import com.miintto.weekend.domain.BandUser
import com.miintto.weekend.global.exception.ApiException
import com.miintto.weekend.global.response.http.Http4xx
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BandService(
    private val bandRepository: BandRepositoryPort,
    private val userBandRepository: BandUserRepositoryPort,
) : BandUseCase {
    @Transactional
    override fun createBand(command: BandCreateCommand, userId: Long): Band {
        val band = bandRepository.save(Band(name = command.name, isActive = true, thumbnail = null))
        userBandRepository.save(BandUser(userId = userId, bandId = band.id, memberType = command.memberType))
        return band
    }

    override fun findBandInfo(bandId: Long): Band {
        return bandRepository.findById(bandId) ?: throw ApiException(Http4xx.BAND_NOT_FOUND)
    }
}
