package com.miintto.weekend.global.response.http

import org.springframework.http.HttpStatus

enum class Http5xx(
    override val code: String,
    override val message: String,
    override val status: HttpStatus,
) : BaseHttp {
    INTERNAL_SERVER_ERROR("E000", "서버 에러", HttpStatus.INTERNAL_SERVER_ERROR),
}
