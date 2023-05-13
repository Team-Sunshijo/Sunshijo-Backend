package com.sunshijo.teacher

import com.sunshijo.domain.teacher.api.dto.request.DomainSignInRequest
import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.exception.PasswordMismatchException
import com.sunshijo.domain.teacher.spi.CommandRefreshPort
import com.sunshijo.domain.teacher.spi.QueryUserPort
import com.sunshijo.domain.teacher.spi.UserJwtPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort
import com.sunshijo.domain.teacher.spi.dto.SpiTokenResponse
import com.sunshijo.domain.teacher.usecase.SignInUseCase
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import java.time.LocalDateTime

internal class SignInUseCaseTest : DescribeSpec({

    val queryUserPort: QueryUserPort = mockk()
    val userJwtPort: UserJwtPort = mockk()
    val commandRefreshPort: CommandRefreshPort = mockk()
    val userSecurityPort: UserSecurityPort = mockk()

    val signInUseCase = SignInUseCase(queryUserPort, userJwtPort, commandRefreshPort, userSecurityPort)

    val request: DomainSignInRequest = mockk()

    describe("SignInUseCase") {
        val teacherId: Long = 1
        val accountId = "testId"
        val password = "testPassword"
        val name = "testName"

        context("잘못된 비밀번호") {
            every { queryUserPort.queryUserByAccountId(accountId) } returns Teacher(
                    accountId = accountId,
                    password = password,
                    name = name
            )
            every { userSecurityPort.matches(password, password) } returns false
            every { request.accountId } returns accountId
            every { request.password } returns password

            it("PasswordMisMatchException이 발생해야 합니다") {
                val exception = shouldThrow<PasswordMismatchException> {
                    signInUseCase.signIn(request)
                }
                exception.message shouldBe "Password Mis Match"
            }
        }

        context("signIn") {
            every { queryUserPort.queryUserByAccountId(accountId) } returns Teacher(
                    id = teacherId,
                    accountId = accountId,
                    password = password,
                    name = name
            )
            every { userSecurityPort.matches(password, password) } returns true
            every { request.password } returns accountId
            every { request.password } returns password
            every { commandRefreshPort.saveRefreshToken(any()) } just Runs

            it("로그인 성공 시 토큰 반환") {
                val accessToken = "testAccessToken"
                val refreshToken = "testRefreshToken"
                val expiresIn = LocalDateTime.now().plusHours(1)
                val tokenResponse = SpiTokenResponse(accessToken, refreshToken, expiresIn)

                every { userJwtPort.provideBothToken(teacherId) } returns tokenResponse

                val result = signInUseCase.signIn(request)

                result.accessToken shouldBe accessToken
                result.refreshToken shouldBe refreshToken
                result.accessTokenExp shouldBe expiresIn
            }
        }
    }
})