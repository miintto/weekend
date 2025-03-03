package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.application.command.RegisterUserCommand

interface RegisterUserUseCase {
    fun registerUser(command: RegisterUserCommand): String
}
