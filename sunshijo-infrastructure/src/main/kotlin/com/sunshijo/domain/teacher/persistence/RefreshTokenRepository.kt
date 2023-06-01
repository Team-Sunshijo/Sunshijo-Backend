package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByRefreshToken(refreshToken: String): RefreshTokenEntity?
}