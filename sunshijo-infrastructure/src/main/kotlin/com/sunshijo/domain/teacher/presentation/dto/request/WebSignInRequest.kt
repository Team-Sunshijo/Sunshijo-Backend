package com.sunshijo.domain.teacher.presentation.dto.request

import javax.validation.constraints.NotBlank

class WebSignInRequest(

        @NotBlank
        val accountId: String,

        @NotBlank
        val password: String
)