package com.miintto.weekend.adaptor.out.persistence.repository

import com.miintto.weekend.adaptor.out.persistence.entity.BandEntity
import com.miintto.weekend.adaptor.out.persistence.entity.BandUserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BandUserJpaRepository : JpaRepository<BandUserEntity, Long> {
    @Query(
        """
        SELECT b FROM BandEntity b
        JOIN BandUserEntity bu ON b.id = bu.bandId
        WHERE bu.userId = :userId
        """
    )
    fun findBandsByUserId(
        @Param("userId")
        userId: Long,
    ): List<BandEntity>

    fun findByBandIdAndUserId(bandId: Long, userId: Long): BandUserEntity?
}
