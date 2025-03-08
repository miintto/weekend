package com.miintto.weekend.config.wrapper

import jakarta.servlet.ReadListener
import jakarta.servlet.ServletInputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import org.apache.tomcat.util.http.fileupload.IOUtils
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class ContentCachingRequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private var content = ByteArrayOutputStream()

    override fun getInputStream(): ServletInputStream {
        IOUtils.copy(super.getInputStream(), content)  // 최초에 stream을 읽어서 캐싱합니다.

        return object : ServletInputStream() {
            private var buffer = ByteArrayInputStream(content.toByteArray())
            override fun read(): Int = buffer.read()
            override fun isFinished(): Boolean = buffer.available() == 0
            override fun isReady(): Boolean = true
            override fun setReadListener(listener: ReadListener?) = throw RuntimeException("Not implemented")
        }
    }

    val contentAsByteArray: ByteArray
        get() = this.inputStream.readAllBytes()

}