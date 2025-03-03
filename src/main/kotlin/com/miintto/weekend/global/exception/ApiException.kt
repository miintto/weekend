package com.miintto.weekend.global.exception

import com.miintto.weekend.global.response.http.BaseHttp

class ApiException(val http: BaseHttp, val data: Any?) : Exception(http.message) {
    constructor(http: BaseHttp) : this(http, null)
}
