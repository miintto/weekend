package com.miintto.weekend.adaptor.out.persistence.entity

import com.miintto.weekend.domain.BandUser
import com.miintto.weekend.domain.enums.MemberType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "t_band_user")
data class BandUserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val bandId: Long,
    val userId: Long,
    val memberType: MemberType,
) {
    fun toDomain() = BandUser(id = id, bandId = bandId, userId = userId, memberType = memberType)

    companion object {
        fun fromDomain(bandUser: BandUser): BandUserEntity
            = BandUserEntity(
                id = bandUser.id,
                bandId = bandUser.bandId,
                userId = bandUser.userId,
                memberType = bandUser.memberType,
            )
    }
}
