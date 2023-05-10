package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.spi.dto.SpiTokenResponse

interface UserJwtPort {
    fun provideBothToken(userId: Long): SpiTokenResponse
}