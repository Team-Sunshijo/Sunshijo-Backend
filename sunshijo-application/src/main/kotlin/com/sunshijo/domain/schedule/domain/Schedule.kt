package com.sunshijo.domain.schedule.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.subject.domain.Subject
import com.sunshijo.domain.teacher.domain.Teacher
import java.util.Date

@Aggregate
class Schedule (

        val id: Long,

        val grade: Int,

        val classNum: Int,

        val period: Int,

        val weekOfDate: Date,

        val teacher: Teacher,

        val subject: Subject
)