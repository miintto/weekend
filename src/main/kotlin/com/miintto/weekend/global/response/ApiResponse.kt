package com.miintto.weekend.global.response

import com.miintto.weekend.global.response.http.BaseHttp
import org.springframework.http.ResponseEntity

class ApiResponse(http: BaseHttp, data: Any?) : ResponseEntity<ResponseDto>(
    ResponseDto(
        http.code,
        http.message,
        data,
    ),
    http.status,
) {
    constructor(http: BaseHttp) : this(http, null)
}
