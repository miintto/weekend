package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.application.command.SongCreateCommand
import com.miintto.weekend.domain.Song

interface SongUseCase {
    fun createSong(command: SongCreateCommand, userId: Long): Song

    fun findSongInfo(songId: Long): Song

    fun findBandSongs(bandId: Long): List<Song>
}
