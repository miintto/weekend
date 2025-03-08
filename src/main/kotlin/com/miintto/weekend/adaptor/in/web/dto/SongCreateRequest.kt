package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.SongCreateCommand

data class SongCreateRequest(
    val bandId: Long,
    val title: String,
    val singer: String,
    val thumbnail: String? = null,
) {
    fun toCommand() = SongCreateCommand(bandId = bandId, title = title, singer = singer, thumbnail = thumbnail)
}
