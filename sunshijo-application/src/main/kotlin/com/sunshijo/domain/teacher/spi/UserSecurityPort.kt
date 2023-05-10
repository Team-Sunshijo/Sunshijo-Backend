package com.sunshijo.domain.teacher.spi

interface UserSecurityPort {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean
}