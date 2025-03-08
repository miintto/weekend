package com.miintto.weekend.domain

import com.miintto.weekend.domain.enums.MemberType

data class BandUser(
    val id: Long = 0,
    val bandId: Long,
    val userId: Long,
    val memberType: MemberType,
)
