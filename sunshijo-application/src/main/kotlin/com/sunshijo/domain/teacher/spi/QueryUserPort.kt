package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.domain.Teacher

interface QueryUserPort {

    fun queryUserByAccountId(accountId: String): Teacher

    fun existsByAccountId(accountId: String): Boolean

    fun queryTeacher(): List<Teacher>
}