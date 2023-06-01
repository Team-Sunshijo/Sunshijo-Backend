package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.domain.RefreshToken

interface QueryRefreshTokenPort {

    fun queryRefreshTokenByToken(token: String): RefreshToken
}