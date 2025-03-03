package com.miintto.weekend.adaptor.out.persistence

import com.miintto.weekend.domain.User
import jakarta.persistence.Column
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

    @Column(nullable = false)
    val name: String,

    @Column(unique = true, nullable = false)
    val email: String,

    val hashedPassword: String,

    val isActive: Boolean = true,

    val isAdmin: Boolean = false,

    val updatedDtm: LocalDateTime? = null,

    val createdDtm: LocalDateTime = LocalDateTime.now(),
) {
    fun toDomain() = User(id = id, name = name, email = email, password = hashedPassword)

    companion object {
        fun fromDomain(user: User) =
            UserEntity(
                id = user.id,
                name = user.name,
                email = user.email,
                hashedPassword = user.password,
            )
    }
}
