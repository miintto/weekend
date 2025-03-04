package com.miintto.weekend.application.service

import com.miintto.weekend.application.command.EmailCheckCommand
import com.miintto.weekend.application.command.LoginUserCommand
import com.miintto.weekend.application.command.SignUpUserCommand
import com.miintto.weekend.application.port.`in`.AuthUseCase
import com.miintto.weekend.application.port.out.UserRepositoryPort
import com.miintto.weekend.domain.User
import com.miintto.weekend.global.exception.ApiException
import com.miintto.weekend.global.response.http.Http4xx
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepositoryPort: UserRepositoryPort,
    private val passwordEncoder: BCryptPasswordEncoder,
) : AuthUseCase {
    override fun checkEmail(command: EmailCheckCommand) {
        if (userRepositoryPort.findByEmail(command.email) != null) {
            throw ApiException(Http4xx.DUPLICATED_EMAIL)
        }
    }

    override fun signUpUser(command: SignUpUserCommand): String {
        if (command.password != command.passwordCheck) {
            throw ApiException(Http4xx.PASSWORD_MISMATCHED)
        } else if (userRepositoryPort.findByEmail(command.email) != null) {
            throw ApiException(Http4xx.DUPLICATED_EMAIL)
        }
        val user = User(
            name = command.name,
            email = command.email,
            password = passwordEncoder.encode(command.password),
        )
        userRepositoryPort.save(user)
        return "authToken" // TODO( JWT 토큰 구현 )
    }

    override fun loginUser(command: LoginUserCommand): String {
        val user = userRepositoryPort.findByEmail(command.email) ?: throw ApiException(Http4xx.AUTHENTICATION_FAILED)
        if (!passwordEncoder.matches(command.password, user.password)) {
            throw ApiException(Http4xx.AUTHENTICATION_FAILED)
        }
        return "authToken" // TODO( JWT 토큰 구현 )
    }
}
