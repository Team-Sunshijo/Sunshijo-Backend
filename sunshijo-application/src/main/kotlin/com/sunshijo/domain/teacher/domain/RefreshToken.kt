package com.sunshijo.domain.teacher.domain

import com.sunshijo.annotation.Aggregate

@Aggregate
class RefreshToken (

        val id: String,

        var refreshToken: String,

        var ttl: Long
) {
    fun updateToken(refreshToken: String, ttl: Long) {
        this.refreshToken = refreshToken
        this.ttl = ttl
    }
}