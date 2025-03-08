package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.domain.Song

data class SongResponse(
    val id: Long,
    val title: String,
    val singer: String,
    val status: String,
    val thumbnail: String?,
) {
    companion object {
        fun fromDomain(song: Song): SongResponse
            = SongResponse(
                id = song.id,
                title = song.title,
                singer = song.singer,
                status = song.status.description,
                thumbnail = song.thumbnail,
            )
    }
}
