package com.miintto.weekend.domain

import com.miintto.weekend.domain.enums.SongStatus
import java.time.LocalDateTime

data class Song(
    val id: Long = 0,
    val userId: Long? = null,
    val bandId: Long,
    val status: SongStatus,
    val title: String,
    val singer: String,
    val thumbnail: String?,
    val isActive: Boolean,
    val inProgressDtm: LocalDateTime?,
    val closedDtm: LocalDateTime?,
)
