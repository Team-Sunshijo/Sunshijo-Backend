package com.sunshijo.domain.dateTimetable.api.dto.request

import java.sql.Date

class QueryTimetableIdRequest (

    val date: Date,

    val subject: String,

    val grade: Int,

    val classNum: Int,

    val period: Int
)