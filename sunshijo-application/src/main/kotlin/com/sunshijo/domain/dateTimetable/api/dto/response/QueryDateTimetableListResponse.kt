package com.sunshijo.domain.dateTimetable.api.dto.response

data class QueryDateTimetableListResponse(
    val timetableList: List<TimetableResponse>
)

class TimetableResponse(

    val grade: Int,

    val classNum: Int,

    val period: Int,

    val weekOfDate: Int,

    val subject: String,
)