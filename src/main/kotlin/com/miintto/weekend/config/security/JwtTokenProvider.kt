package com.miintto.weekend.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtTokenProvider(
    @Value("\${jwt.secret}")
    private val jwtSecret: String,
) {
    private val accessExpirationInterval = 60 * 60 * 1000L // 1시간

    private val key: SecretKey = Keys.hmacShaKeyFor(jwtSecret.toByteArray())

    private fun buildToken(claims: Claims, expirationInterval: Long): String {
        return Jwts.builder()
            .claims(claims)
            .issuedAt(Date())
            .expiration(Date(Date().time + expirationInterval))
            .signWith(key, Jwts.SIG.HS256)
            .compact()
    }

    fun generateAccessToken(userId: Long, email: String): String {
        val claims = Jwts.claims()
            .add("userId", userId)
            .add("email", email)
            .add("type", TokenType.ACCESS.value)
            .build()
        return buildToken(claims, accessExpirationInterval)
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
            return true
        } catch (e: Exception) {
            return false
        }
    }
}