package com.sunshijo.domain.dateTimetable.api

import com.sunshijo.domain.dateTimetable.api.dto.request.QueryTimetableIdRequest
import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableIdResponse

interface QueryTimetableId {
    fun execute(request: QueryTimetableIdRequest): QueryDateTimetableIdResponse
}