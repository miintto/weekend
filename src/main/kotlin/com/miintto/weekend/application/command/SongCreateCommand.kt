package com.miintto.weekend.application.command

import com.miintto.weekend.domain.Song
import com.miintto.weekend.domain.enums.SongStatus

data class SongCreateCommand(
    val bandId: Long,
    val title: String,
    val singer: String,
    val thumbnail: String?,
) {
    fun toDomain(userId: Long = 0) = Song(
        bandId = bandId,
        title = title,
        singer = singer,
        thumbnail = thumbnail,
        userId = userId,
        status = SongStatus.PENDING,
        isActive = true,
        inProgressDtm = null,
        closedDtm = null,
    )
}
