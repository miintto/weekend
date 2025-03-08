package com.miintto.weekend.application.port.out

import com.miintto.weekend.domain.Song

interface SongRepositoryPort {
    fun save(song: Song): Song

    fun findById(id: Long): Song?

    fun findByBandId(bandId: Long): List<Song>
}
