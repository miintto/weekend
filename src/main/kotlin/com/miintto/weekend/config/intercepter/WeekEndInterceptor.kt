package com.miintto.weekend.config.intercepter

import com.miintto.weekend.config.wrapper.ContentCachingRequestWrapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.util.ContentCachingResponseWrapper
import java.lang.Exception

class WeekEndInterceptor : HandlerInterceptor {
    private val logger = LoggerFactory.getLogger(WeekEndInterceptor::class.java)

    private fun getRequestUri(request: HttpServletRequest): String {
        return if (request.queryString == null) {
            "${request.method} ${request.requestURI}"
        } else {
            "${request.method} ${request.requestURI}?${request.queryString}"
        }
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        logger.info(getRequestUri(request))
        val wrapRequest = request as ContentCachingRequestWrapper
        val requestBody = String(wrapRequest.contentAsByteArray)
        if (requestBody.isNotBlank()) {
            logger.info("Request - $requestBody")
        }
        return super.preHandle(request, response, handler)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?,
    ) {
        logger.info("${getRequestUri(request)} - ${response.status}")
        val wrapResponse = response as ContentCachingResponseWrapper
        logger.info("Response - ${String(wrapResponse.contentAsByteArray)}")
        super.afterCompletion(request, response, handler, ex)
    }
}
