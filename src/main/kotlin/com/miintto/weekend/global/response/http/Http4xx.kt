package com.miintto.weekend.global.response.http

import org.springframework.http.HttpStatus

enum class Http4xx(
    override val code: String,
    override val message: String,
    override val status: HttpStatus,
) : BaseHttp {
    BAD_REQUEST("F000", "잘못된 요청", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED("F001", "잘못된 인증 정보입니다.", HttpStatus.UNAUTHORIZED),
    PERMISSION_DENIED("F002", "권한이 없습니다.", HttpStatus.FORBIDDEN),
    INVALID_PARAMETER("F003", "유효하지 않은 파라미터입니다.", HttpStatus.UNPROCESSABLE_ENTITY),
    DUPLICATED_EMAIL("F004", "이미 사용중인 이메일입니다.", HttpStatus.UNPROCESSABLE_ENTITY),
    PASSWORD_MISMATCHED("F005", "패스워드가 서로 일치하지 않습니다.", HttpStatus.UNPROCESSABLE_ENTITY),
    AUTHENTICATION_FAILED("F006", "이메일 혹은 비밀번호가 일치하지 않습니다.", HttpStatus.UNPROCESSABLE_ENTITY),
    BAND_NOT_FOUND("F007", "밴드를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
}
