package com.sunshijo.domain.teacher.domain

import com.sunshijo.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
class RefreshToken (

        val id: String,

        var refreshToken: String,

        var ttl: LocalDateTime
) {
    fun updateToken(refreshToken: String, ttl: LocalDateTime) {
        this.refreshToken = refreshToken
        this.ttl = ttl
    }
}