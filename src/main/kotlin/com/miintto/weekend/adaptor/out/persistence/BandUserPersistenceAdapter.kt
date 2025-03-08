package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.adaptor.out.persistence.entity.BandUserEntity
import com.miintto.weekend.adaptor.out.persistence.repository.BandUserJpaRepository
import com.miintto.weekend.application.port.out.BandUserRepositoryPort
import com.miintto.weekend.domain.Band
import com.miintto.weekend.domain.BandUser
import org.springframework.stereotype.Repository

@Repository
class BandUserPersistenceAdapter(
    private val bandUserJpaRepository: BandUserJpaRepository,
) : BandUserRepositoryPort {
    override fun save(bandUser: BandUser): BandUser {
        return bandUserJpaRepository.save(BandUserEntity.fromDomain(bandUser)).toDomain()
    }

    override fun findUserBand(userId: Long): List<Band> {
        return bandUserJpaRepository.findBandsByUserId(userId).map { it.toDomain() }
    }
}
