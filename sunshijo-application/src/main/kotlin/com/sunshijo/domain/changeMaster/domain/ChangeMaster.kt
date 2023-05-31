package com.sunshijo.domain.changeMaster.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.teacher.domain.Teacher
import java.sql.Date

@Aggregate
class ChangeMaster(

    val id: Long = 0,

    val reason: String,

    val confirmed: Confirmed,

    val date: Date,

    val teacherId: Long

)