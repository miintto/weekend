package com.miintto.weekend.adaptor.`in`.web

import com.miintto.weekend.adaptor.`in`.web.dto.RegisterUserRequest
import com.miintto.weekend.application.port.`in`.RegisterUserUseCase
import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http2xx
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val registerUseCase: RegisterUserUseCase,
) {
    @PostMapping("/register")
    fun register(
        @RequestBody
        request: RegisterUserRequest,
    ): ApiResponse {
        return ApiResponse(Http2xx.SUCCESS, registerUseCase.registerUser(request.toCommand()))
    }
}
