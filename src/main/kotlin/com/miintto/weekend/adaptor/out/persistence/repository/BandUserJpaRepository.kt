package com.miintto.weekend.adaptor.out.persistence.repository

import com.miintto.weekend.adaptor.out.persistence.entity.BandUserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BandUserJpaRepository : JpaRepository<BandUserEntity, Long>
