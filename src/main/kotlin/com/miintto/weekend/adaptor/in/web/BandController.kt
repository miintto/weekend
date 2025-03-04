package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.BandResponse
import com.miintto.weekend.application.port.`in`.BandUseCase
import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http2xx
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/band")
class BandController(
    private val bandUseCase: BandUseCase,
) {
    @GetMapping("/{band-id}")
    fun getBandInfo(
        @PathVariable("band-id")
        bandId: Long,
    ): ApiResponse {
        val band = bandUseCase.findBandInfo(bandId)
        return ApiResponse(Http2xx.OK, BandResponse.fromDomain(band))
    }
}
