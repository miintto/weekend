package com.miintto.weekend.domain

import java.time.LocalDateTime

data class User(
    val id: Long = 0,
    val name: String,
    val email: String,
    val password: String,
    val isActive: Boolean,
    val isAdmin: Boolean,
    val updatedDtm: LocalDateTime? = null,
    val createdDtm: LocalDateTime,
)
