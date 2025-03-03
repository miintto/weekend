package com.miintto.weekend.global.response.http

import org.springframework.http.HttpStatus

interface BaseHttp {
    val code: String
    val message: String
    val status: HttpStatus
}
