package com.sunshijo.domain.teacher.api

import com.sunshijo.domain.teacher.api.dto.response.TokenResponse

interface TokenRefreshPort {

    fun execute(token: String): TokenResponse
}