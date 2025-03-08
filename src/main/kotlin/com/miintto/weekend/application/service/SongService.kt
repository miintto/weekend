package com.miintto.weekend.application.service

import com.miintto.weekend.application.command.SongCreateCommand
import com.miintto.weekend.application.port.`in`.SongUseCase
import com.miintto.weekend.application.port.out.BandUserRepositoryPort
import com.miintto.weekend.application.port.out.SongRepositoryPort
import com.miintto.weekend.domain.Song
import com.miintto.weekend.global.exception.ApiException
import com.miintto.weekend.global.response.http.Http4xx
import org.springframework.stereotype.Service

@Service
class SongService(
    private val bandUserRepository: BandUserRepositoryPort,
    private val songRepository: SongRepositoryPort,
) : SongUseCase {
    override fun createSong(command: SongCreateCommand, userId: Long): Song {
        if (!bandUserRepository.exists(command.bandId, userId)) {
            throw ApiException(Http4xx.BAND_NOT_REGISTERED)
        }
        return songRepository.save(command.toDomain(userId))
    }

    override fun findSongInfo(songId: Long): Song {
        return songRepository.findById(songId) ?: throw ApiException(Http4xx.SONG_NOT_FOUND)
    }

    override fun findBandSongs(bandId: Long): List<Song> {
        return songRepository.findByBandId(bandId)
    }
}
