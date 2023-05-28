package com.sunshijo.domain.teacher.spi.dto

import java.time.LocalDateTime

class SpiTokenResponse(

    val accessToken: String,

    val refreshToken: String,

    val accessTokenExp: LocalDateTime
)