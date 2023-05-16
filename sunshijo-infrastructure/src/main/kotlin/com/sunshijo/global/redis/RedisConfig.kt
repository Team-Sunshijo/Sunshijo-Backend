package com.sunshijo.global.redis

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import java.time.Duration

@Configuration
class RedisConfig (

        @Value("\${redis.host}")
        private val redisHost: String,

        @Value("\${redis.port}")
        private val redisPort: Int,

        @Value("\${REDIS_PASSWORD}")
        private val redisPassword: String

) {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val redisConfig = RedisStandaloneConfiguration(redisHost, redisPort)
        redisConfig.setPassword(RedisPassword.of(redisPassword))

        val clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(1))
                .shutdownTimeout(Duration.ZERO)
                .build()

        return LettuceConnectionFactory(redisConfig, clientConfig)
    }
}