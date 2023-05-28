package com.sunshijo.domain.teacher.presentation.dto.request

class WebSignUpRequest(
    val accountId: String,

    val password: String,

    val name: String,

    val signUpCode: String
)