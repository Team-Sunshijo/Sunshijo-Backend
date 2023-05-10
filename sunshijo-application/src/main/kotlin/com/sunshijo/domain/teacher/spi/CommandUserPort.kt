package com.sunshijo.domain.teacher.spi

import com.sunshijo.domain.teacher.domain.Teacher

interface CommandUserPort {
    fun saveUser(teacher: Teacher)
}