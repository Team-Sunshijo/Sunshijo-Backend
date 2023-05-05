package com.sunshijo.domain.teacher.spi.dto

class SpiTokenResponse (

        val accessToken: String,

        val refreshToken: String,

        val refreshTokenExp: Long
)