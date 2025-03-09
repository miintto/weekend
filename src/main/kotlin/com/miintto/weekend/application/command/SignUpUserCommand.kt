package com.miintto.weekend.application.command

import com.miintto.weekend.domain.User
import java.time.LocalDateTime

data class SignUpUserCommand(
    val name: String,
    val email: String,
    val password: String,
    val passwordCheck: String,
) {
    fun toDomain(): User
        = User(
            name = name,
            email = email,
            password = password,
            isActive = true,
            isAdmin = false,
            updatedDtm = null,
            createdDtm = LocalDateTime.now(),
        )
}
