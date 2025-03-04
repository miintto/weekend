package com.miintto.weekend.adaptor.out.persistence.entity

import com.miintto.weekend.domain.Band
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "t_band")
data class BandEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val isActive: Boolean = true,
    val thumbnail: String? = null,
    val updatedDtm: LocalDateTime? = null,
    val createdDtm: LocalDateTime = LocalDateTime.now(),
) {
    fun toDomain(): Band
        = Band(
            id = id,
            name = name,
            isActive = isActive,
            thumbnail = thumbnail,
        )

    companion object {
        fun fromDomain(band: Band): BandEntity
            = BandEntity(
                id = band.id,
                name = band.name,
                isActive = band.isActive,
                thumbnail = band.thumbnail,
            )
    }
}
