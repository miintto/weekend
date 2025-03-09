package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.BandResponse
import com.miintto.weekend.adaptor.`in`.web.dto.UserResponse
import com.miintto.weekend.application.port.`in`.UserUseCase
import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http2xx
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userUseCase: UserUseCase,
) {
    @GetMapping("/{user-id}")
    fun getUserInfo(
        @PathVariable("user-id")
        userId: Long,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, UserResponse.fromDomain(userUseCase.findUserInfo(userId)))
    }

    @GetMapping("/me")
    fun getMyInfo(
        @AuthenticationPrincipal
        userDetails: UserDetails,
    ): ApiResponse {
        return ApiResponse(
            Http2xx.OK,
            UserResponse.fromDomain(userUseCase.findUserInfo(userDetails.username.toLong())),
        )
    }

    @GetMapping("/me/band")
    fun getMyBand(
        @AuthenticationPrincipal
        userDetails: UserDetails,
    ): ApiResponse {
        return ApiResponse(
            Http2xx.OK,
            userUseCase.findUserBand(userDetails.username.toLong()).map { BandResponse.fromDomain(it) },
        )
    }
}
