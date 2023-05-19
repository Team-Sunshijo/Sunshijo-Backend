package com.sunshijo.teacher

import com.sunshijo.domain.teacher.api.dto.request.DomainSignUpRequest
import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.exception.SignUpCodeMismatchException
import com.sunshijo.domain.teacher.spi.CommandUserPort
import com.sunshijo.domain.teacher.spi.QueryUserPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort
import com.sunshijo.domain.teacher.usecase.SignUpUseCase
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk

internal class SignUpUseCaseTest : DescribeSpec({

    val commandUserPort: CommandUserPort = mockk()
    val userSecurityPort: UserSecurityPort = mockk()
    val queryUserPort: QueryUserPort = mockk()

    val signUpUseCase = SignUpUseCase(commandUserPort, userSecurityPort, queryUserPort)

    val request: DomainSignUpRequest = mockk()

    describe("SignUpUseCase") {
        val accountId = "testId"
        val password = "testPassword"
        val name = "testName"
        val signUpCode = "DsmTeacher"

        context("잘못된 인증코드") {
            every { request.accountId } returns accountId
            every { request.password } returns password
            every { request.name } returns name
            every { request.signUpCode } returns "incorrectCode"
            every { queryUserPort.existsByAccountId(any()) } returns false
            it("SignUpCodeMismatchException이 발생해야 합니다") {
                val exception = shouldThrow<SignUpCodeMismatchException> {
                    signUpUseCase.signUp(request)
                }
                exception.message shouldBe "SignUp Code Mis Match"
            }
        }

        context("올바른 인증코드") {
            every { request.accountId } returns accountId
            every { request.password } returns password
            every { request.name } returns name
            every { request.signUpCode } returns signUpCode
            every { queryUserPort.existsByAccountId(any()) } returns false
            every { userSecurityPort.encodePassword(any()) } returns "encodedPassword"
            every { commandUserPort.saveUser(any()) } just Runs

            it("사용자가 저장되어야 합니다") {
                signUpUseCase.signUp(request)
                commandUserPort.saveUser(Teacher(
                        accountId = accountId,
                        password = userSecurityPort.encodePassword(password),
                        name = name
                ))
            }
        }
    }
})