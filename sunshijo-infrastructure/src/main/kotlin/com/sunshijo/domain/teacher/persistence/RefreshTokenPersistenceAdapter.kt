package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.domain.RefreshToken
import com.sunshijo.domain.teacher.mapper.RefreshTokenMapper
import com.sunshijo.domain.teacher.spi.RefreshTokenPort
import com.sunshijo.global.annotation.Adapter

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
) : RefreshTokenPort {

    override fun saveRefreshToken(refreshToken: RefreshToken) {
        refreshTokenRepository.save(refreshTokenMapper.toEntity(refreshToken))
    }
}