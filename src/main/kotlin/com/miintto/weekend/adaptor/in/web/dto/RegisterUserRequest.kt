package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.application.command.RegisterUserCommand

data class RegisterUserRequest(
    val name: String,
    val email: String,
    val password: String,
    val passwordCheck: String,
) {
    fun toCommand() = RegisterUserCommand(name, email, password, passwordCheck)
}
