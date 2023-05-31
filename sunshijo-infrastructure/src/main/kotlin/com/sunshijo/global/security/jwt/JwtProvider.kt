package com.sunshijo.global.security.jwt

import com.sunshijo.domain.teacher.spi.UserJwtPort
import com.sunshijo.domain.teacher.spi.dto.SpiTokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider(
    private val securityProperties: SecurityProperties
) : UserJwtPort {

    private fun createAccessToken(accountId: String) =
        generateToken(accountId, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(accountId: String) =
        generateToken(accountId, JwtProperties.REFRESH, securityProperties.refreshExp)

    private fun generateToken(accountId: String, type: String, ttl: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", "jwt")
            .claim("type", type)
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    override fun provideBothToken(accountId: String) = SpiTokenResponse(
        accessToken = createAccessToken(accountId),
        refreshToken = createRefreshToken(accountId),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )
}