package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.SongCreateRequest
import com.miintto.weekend.adaptor.`in`.web.dto.SongResponse
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
@RequestMapping("/song")
class SongController(
    private val songUseCase: SongUseCase,
) {
    @PostMapping("")
    fun createSong(
        @RequestBody
        request: SongCreateRequest,
        @AuthenticationPrincipal
        userDetails: UserDetails,
    ): ApiResponse {
        return ApiResponse(
            Http2xx.CREATED,
            SongResponse.fromDomain(songUseCase.createSong(request.toCommand(), userDetails.username.toLong())),
        )
    }

    @GetMapping("/{song-id}")
    fun getSongInfo(
        @PathVariable("song-id")
        songId: Long,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, SongResponse.fromDomain(songUseCase.findSongInfo(songId)))
    }
}
