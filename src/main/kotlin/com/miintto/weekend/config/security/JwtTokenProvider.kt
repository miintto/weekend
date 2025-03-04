package com.miintto.weekend.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
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

    private fun decodeToken(token: String): Jws<Claims> {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
    }

    fun generateAccessToken(userId: Long, email: String): String {
        val claims = Jwts.claims().id(userId.toString())
            .add("email", email)
            .add("type", TokenType.ACCESS.value)
            .build()
        return buildToken(claims, accessExpirationInterval)
    }

    fun validateToken(token: String): Boolean {
        return try {
            decodeToken(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = decodeToken(token)
        val userDetails = User.builder()
            .username(claims.payload.id)
            .password("")
            .build()
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }
}
