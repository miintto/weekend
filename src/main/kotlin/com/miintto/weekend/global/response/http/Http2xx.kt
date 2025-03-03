package com.miintto.weekend.global.response.http

import org.springframework.http.HttpStatus

enum class Http2xx(
    override val code: String,
    override val message: String,
    override val status: HttpStatus,
) : BaseHttp {
    OK("S000", "성공", HttpStatus.OK),
    CREATED("S001", "생성 완료", HttpStatus.CREATED),
}
