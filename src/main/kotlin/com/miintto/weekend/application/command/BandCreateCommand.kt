package com.miintto.weekend.application.command

import com.miintto.weekend.domain.enums.MemberType

data class BandCreateCommand(
    val name: String,
    val memberType: MemberType = MemberType.NORMAL,
)
