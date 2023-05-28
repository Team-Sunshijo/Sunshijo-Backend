package com.sunshijo.domain.teacher.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.teacher.api.SignInPort
import com.sunshijo.domain.teacher.api.dto.request.DomainSignInRequest
import com.sunshijo.domain.teacher.api.dto.response.SignInResponse
import com.sunshijo.domain.teacher.domain.RefreshToken
import com.sunshijo.domain.teacher.exception.PasswordMismatchException
import com.sunshijo.domain.teacher.spi.CommandRefreshPort
import com.sunshijo.domain.teacher.spi.QueryUserPort
import com.sunshijo.domain.teacher.spi.UserJwtPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort
import java.time.ZoneId
import java.time.ZoneOffset

@UseCase
open class SignInUseCase(
    private val queryUserPort: QueryUserPort,
    private val userJwtPort: UserJwtPort,
    private val commandRefreshPort: CommandRefreshPort,
    private val userSecurityPort: UserSecurityPort
) : SignInPort {

    override fun signIn(request: DomainSignInRequest): SignInResponse {
        val user = queryUserPort.queryUserByAccountId(request.accountId)

        if (!userSecurityPort.matches(request.password, user.password)) {
            throw PasswordMismatchException
        }

        val tokenResponse = userJwtPort.provideBothToken(user.id)

        commandRefreshPort.saveRefreshToken(
            RefreshToken(
                id = user.id.toString(),
                refreshToken = tokenResponse.refreshToken,
                ttl = tokenResponse.accessTokenExp.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli()
            )
        )

        return SignInResponse(
            accessToken = tokenResponse.accessToken,
            refreshToken = tokenResponse.refreshToken,
            accessTokenExp = tokenResponse.accessTokenExp
        )
    }
}