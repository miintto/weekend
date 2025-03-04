package com.miintto.weekend.config.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider,
) : OncePerRequestFilter() {
    private fun resolveToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization") ?: return null
        val authArray = token.split(" ")
        if (authArray.size != 2) {
            return null
        } else if (authArray[0].uppercase() != "BEARER") {
            return null
        }
        return authArray[1]
    }

    private fun setAuthorization(token: String) {
        SecurityContextHolder.getContext().authentication = jwtTokenProvider.getAuthentication(token)
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val token = resolveToken(request)
        if (token != null && jwtTokenProvider.validateToken(token)) {
            setAuthorization(token)
        }
        filterChain.doFilter(request, response)
    }
}
