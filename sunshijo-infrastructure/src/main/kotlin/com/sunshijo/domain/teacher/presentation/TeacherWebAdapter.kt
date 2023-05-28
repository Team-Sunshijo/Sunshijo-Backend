package com.sunshijo.domain.teacher.presentation

import com.sunshijo.domain.teacher.api.SignInPort
import com.sunshijo.domain.teacher.api.SignUpPort
import com.sunshijo.domain.teacher.api.dto.request.DomainSignInRequest
import com.sunshijo.domain.teacher.api.dto.request.DomainSignUpRequest
import com.sunshijo.domain.teacher.api.dto.response.SignInResponse
import com.sunshijo.domain.teacher.presentation.dto.request.WebSignInRequest
import com.sunshijo.domain.teacher.presentation.dto.request.WebSignUpRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/teacher")
@RestController
class TeacherWebAdapter(
    private val signInPort: SignInPort,
    private val signUpPort: SignUpPort
) {

    @PostMapping("/auth")
    fun signIn(@RequestBody @Valid request: WebSignInRequest): SignInResponse {
        return signInPort.signIn(
            DomainSignInRequest(
                accountId = request.accountId,
                password = request.password
            )
        )
    }

    @PostMapping("/register")
    fun signUp(@RequestBody request: WebSignUpRequest) {
        signUpPort.signUp(
            DomainSignUpRequest(
                accountId = request.accountId,
                password = request.password,
                name = request.name,
                signUpCode = request.signUpCode
            )
        )
    }
}