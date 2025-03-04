package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.EmailCheckCommand

data class EmailCheckRequest(
    val email: String,
) {
    fun toCommand() = EmailCheckCommand(email = email)
}
