package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.BandCreateRequest
import com.miintto.weekend.adaptor.`in`.web.dto.BandResponse
import com.miintto.weekend.adaptor.`in`.web.dto.SongResponse
import com.miintto.weekend.application.port.`in`.BandUseCase
import com.miintto.weekend.application.port.`in`.SongUseCase
import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http2xx
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/band")
class BandController(
    private val bandUseCase: BandUseCase,
    private val songUseCase: SongUseCase,
) {
    @PostMapping("")
    fun createBand(
        @RequestBody
        request: BandCreateRequest,
        @AuthenticationPrincipal
        userDetails: UserDetails,
    ): ApiResponse {
        return ApiResponse(
            Http2xx.CREATED,
            BandResponse.fromDomain(bandUseCase.createBand(request.toCommand(), userDetails.username.toLong())),
        )
    }

    @GetMapping("/{band-id}")
    fun getBandInfo(
        @PathVariable("band-id")
        bandId: Long,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, BandResponse.fromDomain(bandUseCase.findBandInfo(bandId)))
    }

    @GetMapping("/{band-id}/songs")
    fun getBandSongs(
        @PathVariable("band-id")
        bandId: Long,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, songUseCase.findBandSongs(bandId).map { SongResponse.fromDomain(it) })
    }
}
