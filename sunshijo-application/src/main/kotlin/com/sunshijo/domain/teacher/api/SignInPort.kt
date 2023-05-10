package com.sunshijo.domain.teacher.api

import com.sunshijo.domain.teacher.api.dto.request.DomainSignInRequest
import com.sunshijo.domain.teacher.api.dto.response.SignInResponse

interface SignInPort {

    fun signIn(request: DomainSignInRequest): SignInResponse
}