package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.adaptor.out.persistence.entity.SongEntity
import com.miintto.weekend.adaptor.out.persistence.repository.SongJpaRepository
import com.miintto.weekend.application.port.out.SongRepositoryPort
import com.miintto.weekend.domain.Song
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class SongPersistenceAdapter(
    private val songJpaRepository: SongJpaRepository,
) : SongRepositoryPort {
    override fun save(song: Song): Song {
        return songJpaRepository.save(SongEntity.fromDomain(song)).toDomain()
    }

    override fun findById(id: Long): Song? {
        return songJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun findByBandId(bandId: Long): List<Song> {
        return songJpaRepository.findByBandIdOrderByIdDesc(bandId).map { it.toDomain() }
    }
}
