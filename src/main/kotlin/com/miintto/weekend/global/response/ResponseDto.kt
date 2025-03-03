package com.miintto.weekend.global.response

data class ResponseDto(
    val code: String,
    val message: String,
    val data: Any?,
)
