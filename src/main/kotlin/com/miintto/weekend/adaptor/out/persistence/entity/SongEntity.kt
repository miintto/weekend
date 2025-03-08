package com.miintto.weekend.adaptor.out.persistence.entity

import com.miintto.weekend.domain.Song
import com.miintto.weekend.domain.enums.SongStatus
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "t_song")
data class SongEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val userId: Long? = null,
    val bandId: Long,
    val status: SongStatus = SongStatus.PENDING,
    val title: String,
    val singer: String,
    val thumbnail: String? = null,
    val isActive: Boolean = true,
    val inProgressDtm: LocalDateTime? = null,
    val closedDtm: LocalDateTime? = null,
    val updatedDtm: LocalDateTime? = null,
    val createdDtm: LocalDateTime = LocalDateTime.now(),
) {
    fun toDomain(): Song
        = Song(
            id = id,
            bandId = bandId,
            userId = userId,
            status = status,
            title = title,
            singer = singer,
            thumbnail = thumbnail,
            isActive = isActive,
            inProgressDtm = inProgressDtm,
            closedDtm = closedDtm,
        )

    companion object {
        fun fromDomain(song: Song): SongEntity
            = SongEntity(
                id = song.id,
                bandId = song.bandId,
                userId = song.userId,
                status = song.status,
                title = song.title,
                singer = song.singer,
                thumbnail = song.thumbnail,
                isActive = song.isActive,
                inProgressDtm = song.inProgressDtm,
                closedDtm = song.closedDtm,
            )
    }
}
