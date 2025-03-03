package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.LoginUserCommand

data class LoginUserRequest(
    val email: String,
    val password: String,
) {
    fun toCommand() = LoginUserCommand(email, password)
}
