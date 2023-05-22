package com.sunshijo.domain.changeMaster.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.teacher.domain.Teacher

@Aggregate
class ChangeMaster (

        val id: Long,

        val reason: String,

        val confirmed: Confirmed,

        val teacher: Teacher

)