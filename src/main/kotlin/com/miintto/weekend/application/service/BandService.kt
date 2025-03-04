package com.miintto.weekend.application.service

import com.miintto.weekend.application.port.`in`.BandUseCase
import com.miintto.weekend.application.port.out.BandRepositoryPort
import com.miintto.weekend.domain.Band
import com.miintto.weekend.global.exception.ApiException
import com.miintto.weekend.global.response.http.Http4xx
import org.springframework.stereotype.Service

@Service
class BandService(
    private val bandRepository: BandRepositoryPort,
) : BandUseCase {
    override fun findBandInfo(bandId: Long): Band {
        return bandRepository.findById(bandId) ?: throw ApiException(Http4xx.BAND_NOT_FOUND)
    }
}
