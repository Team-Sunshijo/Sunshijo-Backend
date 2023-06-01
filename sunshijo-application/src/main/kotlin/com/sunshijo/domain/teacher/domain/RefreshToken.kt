package com.sunshijo.domain.teacher.domain

import com.sunshijo.annotation.Aggregate
import java.time.LocalDateTime

@Aggregate
class RefreshToken(

    val id: String,

    var refreshToken: String,

    var ttl: Long
) {
    fun updateToken(refreshToken: String, ttl: Long): RefreshToken {
        return RefreshToken(
            id = this.id,
            refreshToken = refreshToken,
            ttl = ttl
        )
    }
}