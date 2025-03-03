package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.SignUpUserCommand

data class SignUpUserRequest(
    val name: String,
    val email: String,
    val password: String,
    val passwordCheck: String,
) {
    fun toCommand() = SignUpUserCommand(name, email, password, passwordCheck)
}
