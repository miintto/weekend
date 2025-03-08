package com.miintto.weekend.domain

data class Band(
    val id: Long = 0,
    val name: String,
    val thumbnail: String?,
    val isActive: Boolean,
)
