package com.miintto.weekend.application.port.`in`

import com.miintto.weekend.application.command.EmailCheckCommand
import com.miintto.weekend.application.command.LoginUserCommand
import com.miintto.weekend.application.command.SignUpUserCommand

interface AuthUseCase {
    fun checkEmail(command: EmailCheckCommand)

    fun signUpUser(command: SignUpUserCommand): String

    fun loginUser(command: LoginUserCommand): String
}
