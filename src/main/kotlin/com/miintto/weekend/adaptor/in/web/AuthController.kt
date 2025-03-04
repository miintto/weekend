package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.EmailCheckRequest
import com.miintto.weekend.adaptor.`in`.web.dto.LoginUserRequest
import com.miintto.weekend.adaptor.`in`.web.dto.SignUpUserRequest
import com.miintto.weekend.application.port.`in`.AuthUseCase
import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http2xx
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authUseCase: AuthUseCase,
) {
    @PostMapping("/email/check")
    fun checkEmail(
        @RequestBody
        request: EmailCheckRequest,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, authUseCase.checkEmail(request.toCommand()))
    }

    @PostMapping("/signup")
    fun signUp(
        @RequestBody
        request: SignUpUserRequest,
    ): ApiResponse {
        return ApiResponse(Http2xx.CREATED, authUseCase.signUpUser(request.toCommand()))
    }

    @PostMapping("/login")
    fun login(
        @RequestBody
        request: LoginUserRequest,
    ): ApiResponse {
        return ApiResponse(Http2xx.OK, authUseCase.loginUser(request.toCommand()))
    }
}
