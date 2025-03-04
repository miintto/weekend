package com.miintto.weekend.adaptor.out.persistence.repository

import com.miintto.weekend.adaptor.out.persistence.entity.BandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BandJpaRepository : JpaRepository<BandEntity, Long>
