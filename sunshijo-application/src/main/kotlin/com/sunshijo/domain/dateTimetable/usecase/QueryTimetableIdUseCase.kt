package com.sunshijo.domain.dateTimetable.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.dateTimetable.api.QueryTimetableId
import com.sunshijo.domain.dateTimetable.api.dto.request.QueryTimetableIdRequest
import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableIdResponse
import com.sunshijo.domain.dateTimetable.spi.QueryDateTimetablePort

@UseCase
open class QueryTimetableIdUseCase (
    private val queryDateTimetablePort: QueryDateTimetablePort
) : QueryTimetableId {

    override fun execute(request: QueryTimetableIdRequest): QueryDateTimetableIdResponse {
        val dateTimetable = queryDateTimetablePort.queryDateTimetable(request)

        return QueryDateTimetableIdResponse(
            timetableId = dateTimetable.id
        )
    }
}