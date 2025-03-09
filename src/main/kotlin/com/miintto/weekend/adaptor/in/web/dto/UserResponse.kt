package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.domain.User
import java.time.LocalDateTime

data class UserResponse(
    val id: Long = 0,
    val name: String,
    val email: String,
    val isActive: Boolean,
    val isAdmin: Boolean,
    val updatedDtm: LocalDateTime? = null,
    val createdDtm: LocalDateTime,
) {
    companion object {
        fun fromDomain(user: User): UserResponse
            = UserResponse(
                id = user.id,
                name = user.name,
                email = user.email,
                isActive = user.isActive,
                isAdmin = user.isAdmin,
                updatedDtm = user.updatedDtm,
                createdDtm = user.createdDtm,
            )
    }
}
