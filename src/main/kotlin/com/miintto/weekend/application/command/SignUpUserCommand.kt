package com.miintto.weekend.application.command

data class SignUpUserCommand(
    val name: String,
    val email: String,
    val password: String,
    val passwordCheck: String,
)
