package com.miintto.weekend.adaptor.`in`.web.dto

import com.miintto.weekend.domain.Band

data class BandResponse(
    val id: Long,
    val name: String,
    val thumbnail: String?,
    val isActive: Boolean,
) {
    companion object {
        fun fromDomain(band: Band): BandResponse
            = BandResponse(
                id = band.id,
                name = band.name,
                thumbnail = band.thumbnail,
                isActive = band.isActive,
            )
    }
}
