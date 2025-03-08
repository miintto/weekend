package com.miintto.weekend.adaptor.out.persistence.repository

import com.miintto.weekend.adaptor.out.persistence.entity.SongEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SongJpaRepository : JpaRepository<SongEntity, Long> {
    fun findByBandIdOrderByIdDesc(bandId: Long): List<SongEntity>
}
