package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.spi.dto.SpiTokenResponse
import java.util.UUID

interface UserJwtPort {
    fun provideBothToken(userId: UUID): SpiTokenResponse
}