package com.miintto.weekend.application.command

data class LoginUserCommand(
    val email: String,
    val password: String,
)
