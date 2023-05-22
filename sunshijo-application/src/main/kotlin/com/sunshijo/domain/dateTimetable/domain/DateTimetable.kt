package com.sunshijo.domain.dateTimetable.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.teacher.domain.Teacher
import java.util.*

@Aggregate
class DateTimetable (

        val id: Long,

        val year: Int,

        val semester: Int,

        val date: Date,

        val grade: Int,

        val classNum: Int,

        val period: Int,

        val weekOfDate: Date,

        val subject: String,

        val teacher: Teacher
)