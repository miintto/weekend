package com.miintto.weekend.adaptor.out.persistence.entity

import com.miintto.weekend.domain.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "t_user")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val email: String,
    val hashedPassword: String,
    val isActive: Boolean = true,
    val isAdmin: Boolean = false,
    val updatedDtm: LocalDateTime? = null,
    val createdDtm: LocalDateTime = LocalDateTime.now(),
) {
    fun toDomain(): User
        = User(
            id = id,
            name = name,
            email = email,
            password = hashedPassword,
            isActive = isActive,
            isAdmin = isAdmin,
            updatedDtm = updatedDtm,
            createdDtm = createdDtm,
        )

    companion object {
        fun fromDomain(user: User): UserEntity
            = UserEntity(
                id = user.id,
                name = user.name,
                email = user.email,
                hashedPassword = user.password,
                isActive = user.isActive,
                isAdmin = user.isAdmin,
                updatedDtm = user.updatedDtm,
                createdDtm = user.createdDtm,
            )
    }
}
