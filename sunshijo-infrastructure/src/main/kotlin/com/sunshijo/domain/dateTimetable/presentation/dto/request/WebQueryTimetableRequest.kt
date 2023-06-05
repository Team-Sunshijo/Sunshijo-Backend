package com.sunshijo.domain.dateTimetable.presentation.dto.request

import java.sql.Date

class WebQueryTimetableRequest (

    val date: Date,

    val subject: String,

    val grade: Int,

    val classNum: Int,

    val period: Int

)