package com.sunshijo.domain.teacher.api.dto.response

import java.time.LocalDateTime

class SignInResponse (

        val accessToken: String,

        val refreshToken: String,

        val accessTokenExp: LocalDateTime
)