package com.sunshijo.domain.teacher.persistence.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import javax.persistence.Id

@RedisHash
class RefreshTokenEntity (

        @Id
        val id: String,

        @Indexed
        val refreshToken: String,

        @TimeToLive
        val ttl: Long
)