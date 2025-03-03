package com.miintto.weekend.global.exception

import com.miintto.weekend.global.response.ApiResponse
import com.miintto.weekend.global.response.http.Http5xx
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(value = [Exception::class])
    fun handleException(exception: Exception): ApiResponse {
        return ApiResponse(Http5xx.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [ApiException::class])
    fun handleException(exception: ApiException): ApiResponse {
        return ApiResponse(exception.http, exception.data)
    }
}
