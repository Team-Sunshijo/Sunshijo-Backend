package com.sunshijo.domain.dateTimetable.api

import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse

interface QueryDateTimetableListPort {

    fun execute(grade: Int, classNum: Int): QueryDateTimetableListResponse
}