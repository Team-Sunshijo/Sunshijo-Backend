package com.sunshijo.domain.dateTimetable.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.dateTimetable.api.QueryDateTimetableListPort
import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse
import com.sunshijo.domain.dateTimetable.api.dto.response.TimetableResponse
import com.sunshijo.domain.dateTimetable.spi.QueryDateTimetablePort
import java.sql.Date
import java.time.LocalDate

@UseCase
open class QueryDateTimetableUseCase(
        private val queryDateTimetablePort: QueryDateTimetablePort
) : QueryDateTimetableListPort {

    override fun execute(grade: Int, classNum: Int): QueryDateTimetableListResponse {

        val monday = LocalDate.now().with(java.time.DayOfWeek.MONDAY)
        val friday = monday.plusDays(4)

        val timetableList = queryDateTimetablePort.queryDateTimetableList(grade, classNum, Date.valueOf(monday), Date.valueOf(friday))

        return QueryDateTimetableListResponse(
                timetableList = timetableList
                        .map {
                            TimetableResponse(
                                    grade = it.grade,
                                    classNum = it.classNum,
                                    period = it.period,
                                    weekOfDate = it.weekOfDate,
                                    subject = it.subject
                            )
                        }
        )

    }
}