package com.miintto.weekend.application.command

data class RegisterUserCommand(
    val name: String,
    val email: String,
    val password: String,
    val passwordCheck: String,
)
