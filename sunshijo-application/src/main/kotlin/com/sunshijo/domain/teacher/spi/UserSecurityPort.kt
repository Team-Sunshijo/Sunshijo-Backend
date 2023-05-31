package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.domain.Teacher

interface UserSecurityPort {

    fun encodePassword(password: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean

    fun getCurrentUser(): Teacher
}