package com.sunshijo.domain.teacher.mapper

import com.sunshijo.domain.teacher.domain.RefreshToken
import com.sunshijo.domain.teacher.persistence.entity.RefreshTokenEntity
import com.sunshijo.global.entity.GenericMapper
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper : GenericMapper<RefreshToken, RefreshTokenEntity> {

    override fun toDomain(entity: RefreshTokenEntity): RefreshToken = entity.let {
        RefreshToken(
                id = it.id,
                refreshToken = it.refreshToken,
                ttl = it.ttl
        )
    }


    override fun toEntity(domain: RefreshToken): RefreshTokenEntity = domain.let {
        RefreshTokenEntity(
                id = it.id,
                refreshToken = it.refreshToken,
                ttl = it.ttl
        )
    }

}