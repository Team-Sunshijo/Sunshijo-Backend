package com.sunshijo.domain.teacher.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.teacher.api.TokenRefreshPort
import com.sunshijo.domain.teacher.api.dto.response.TokenResponse
import com.sunshijo.domain.teacher.spi.*
import java.time.ZoneOffset

@UseCase
open class TokenRefreshUseCase(
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val userSecurityPort: UserSecurityPort,
    private val userJwtPort: UserJwtPort,
    private val commandRefreshPort: CommandRefreshPort
) : TokenRefreshPort {

    override fun execute(token: String): TokenResponse {
        val refreshToken = queryRefreshTokenPort.queryRefreshTokenByToken(token)

        val user = userSecurityPort.getCurrentUser()

        val tokenResponse = userJwtPort.provideBothToken(user.accountId)

        commandRefreshPort.saveRefreshToken(
            refreshToken.updateToken(
                tokenResponse.refreshToken,
                tokenResponse.accessTokenExp.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            )
        )

        return TokenResponse(
            accessToken = tokenResponse.accessToken,
            refreshToken = tokenResponse.refreshToken,
            accessTokenExp = tokenResponse.accessTokenExp
        )
    }
}