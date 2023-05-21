package com.sunshijo.domain.timetable.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.teacher.domain.Teacher
import java.util.Date

@Aggregate
class TimeTable (

        val id: Long,

        val grade: Int,

        val classNum: Int,

        val period: Int,

        val weekOfDate: Date,

        val subject: String,

        val teacher: Teacher
)