package com.sunshijo.domain.semesterTimetable.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.teacher.domain.Teacher
import java.util.Date

@Aggregate
class SemesterTimetable (

        val id: Long,

        val year: Int,

        val semester: Int,

        val grade: Int,

        val classNum: Int,

        val period: Int,

        val weekOfDate: Date,

        val subject: String,

        val teacher: Teacher
)