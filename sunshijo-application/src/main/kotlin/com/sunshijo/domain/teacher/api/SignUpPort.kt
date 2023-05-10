package com.sunshijo.domain.teacher.api

import com.sunshijo.domain.teacher.api.dto.request.DomainSignUpRequest

interface SignUpPort {
    fun signUp(request: DomainSignUpRequest)
}