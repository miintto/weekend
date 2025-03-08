package com.miintto.weekend.config

import com.miintto.weekend.config.intercepter.WeekEndInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(WeekEndInterceptor()).addPathPatterns("/**")
    }
}
