package com.sunshijo.domain.teacher.spi

interface UserSecurityPort {

    fun matches(rawPassword: String, encodedPassword: String): Boolean
}