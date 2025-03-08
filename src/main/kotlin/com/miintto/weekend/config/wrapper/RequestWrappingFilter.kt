package com.miintto.weekend.config.wrapper

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingResponseWrapper

@Component
class RequestWrappingFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val wrapRequest = ContentCachingRequestWrapper(request)
        val wrapResponse = ContentCachingResponseWrapper(response)
        filterChain.doFilter(wrapRequest, wrapResponse)
        wrapResponse.copyBodyToResponse()
    }
}
