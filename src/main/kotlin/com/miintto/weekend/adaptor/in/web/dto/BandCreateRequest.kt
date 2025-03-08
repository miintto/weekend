package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.BandCreateCommand

data class BandCreateRequest(
    val name: String,
) {
    fun toCommand() = BandCreateCommand(name = name)
}
