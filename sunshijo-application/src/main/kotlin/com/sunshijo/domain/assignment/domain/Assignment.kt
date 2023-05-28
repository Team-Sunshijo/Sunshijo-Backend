package com.sunshijo.domain.assignment.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.dateTimetable.domain.DateTimetable

@Aggregate
class Assignment(

    val id: Long,

    val content: String,

    val dateTimetable: DateTimetable

)