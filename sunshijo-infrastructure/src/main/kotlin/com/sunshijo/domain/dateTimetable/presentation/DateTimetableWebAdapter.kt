package com.sunshijo.domain.dateTimetable.presentation

import com.sunshijo.domain.dateTimetable.api.QueryDateTimetableListPort
import com.sunshijo.domain.dateTimetable.api.QueryTimetableId
import com.sunshijo.domain.dateTimetable.api.dto.request.QueryTimetableIdRequest
import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableIdResponse
import com.sunshijo.domain.dateTimetable.api.dto.response.QueryDateTimetableListResponse
import com.sunshijo.domain.dateTimetable.presentation.dto.request.WebQueryTimetableRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetable")
@RestController
class DateTimetableWebAdapter(
    private val queryDateTimetableListPort: QueryDateTimetableListPort,
    private val queryTimetableId: QueryTimetableId
) {

    @GetMapping
    fun getTimetableList(@RequestParam("grade") grade: Int, @RequestParam("class") classNum: Int): QueryDateTimetableListResponse {
        return queryDateTimetableListPort.execute(grade, classNum)
    }

    @GetMapping("/id")
    fun getTimetableId(@RequestBody request: WebQueryTimetableRequest): QueryDateTimetableIdResponse {
         return queryTimetableId.execute(QueryTimetableIdRequest(
            date = request.date,
            subject = request.subject,
            grade = request.grade,
            classNum = request.classNum,
            period = request.period
        ))
    }
}