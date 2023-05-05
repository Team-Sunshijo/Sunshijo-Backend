package com.sunshijo.domain.teacher.domain

import com.sunshijo.annotation.Aggregate
import java.util.UUID

@Aggregate
class Teacher (

        val id: UUID,

        val accountId: String,

        val password: String
)