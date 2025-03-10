package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.adaptor.out.persistence.entity.BandEntity
import com.miintto.weekend.adaptor.out.persistence.repository.BandJpaRepository
import com.miintto.weekend.application.port.out.BandRepositoryPort
import com.miintto.weekend.domain.Band
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class BandPersistenceAdapter(
    private val bandJpaRepository: BandJpaRepository,
) : BandRepositoryPort {
    override fun save(band: Band): Band {
        return bandJpaRepository.save(BandEntity.fromDomain(band)).toDomain()
    }

    override fun findById(id: Long): Band? {
        return bandJpaRepository.findByIdOrNull(id)?.toDomain()
    }
}
