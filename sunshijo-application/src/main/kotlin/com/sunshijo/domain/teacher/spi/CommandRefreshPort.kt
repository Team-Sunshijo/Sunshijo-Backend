package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.domain.RefreshToken

interface CommandRefreshPort {

    fun saveRefreshToken(refreshToken: RefreshToken)
}