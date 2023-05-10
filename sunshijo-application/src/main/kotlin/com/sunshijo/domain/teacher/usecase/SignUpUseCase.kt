package com.sunshijo.domain.teacher.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.teacher.api.SignUpPort
import com.sunshijo.domain.teacher.api.dto.request.DomainSignUpRequest
import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.exception.SignUpCodeMismatchException
import com.sunshijo.domain.teacher.spi.CommandUserPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class SignUpUseCase (
        private val commandUserPort: CommandUserPort,
        private val userSecurityPort: UserSecurityPort
) : SignUpPort {

    override fun signUp(request: DomainSignUpRequest) {

        if (request.signUpCode != "DsmTeacher") {
            throw SignUpCodeMismatchException
        }
        commandUserPort.saveUser(Teacher(
                accountId = request.accountId,
                password = userSecurityPort.encodePassword(request.password),
                name = request.name
        ))
    }
}