package com.miintto.weekend.domain.enums

enum class SongStatus(
    val description: String,
) {
    PENDING("대기"),
    INPROGRESS("연습중"),
    CLOSED("종료"),
}
