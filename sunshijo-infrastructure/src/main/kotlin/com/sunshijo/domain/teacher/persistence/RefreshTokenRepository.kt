package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByToken(refreshToken: String): Optional<RefreshTokenEntity>
}