package com.sunshijo.domain.dateTimetable.domain

import com.sunshijo.annotation.Aggregate
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

        val weekOfDate: Int,

        val subject: String,

        val teacherId: Long
)