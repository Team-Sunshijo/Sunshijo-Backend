package com.sunshijo.global.security.jwt

import com.sunshijo.domain.teacher.spi.UserJwtPort
import com.sunshijo.domain.teacher.spi.dto.SpiTokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider (
        private val securityProperties: SecurityProperties
) : UserJwtPort {

    private fun createAccessToken(userId: UUID) =
            generateToken(userId, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(userId: UUID) =
            generateToken(userId, JwtProperties.REFRESH, securityProperties.refreshExp)

    private fun generateToken(userId: UUID, type: String, ttl: Long) =
            Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
                    .setSubject(userId.toString())
                    .setHeaderParam("type", "jwt")
                    .claim("type", type)
                    .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
                    .compact()

    override fun provideBothToken(userId: UUID) = SpiTokenResponse(
            accessToken = createAccessToken(userId),
            refreshToken = createRefreshToken(userId),
            accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )
}