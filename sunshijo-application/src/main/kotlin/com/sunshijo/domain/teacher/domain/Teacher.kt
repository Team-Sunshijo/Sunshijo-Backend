package com.sunshijo.domain.teacher.domain

import com.sunshijo.annotation.Aggregate

@Aggregate
class Teacher (

        val id: Long,

        val accountId: String,

        val password: String,

        val name: String
)