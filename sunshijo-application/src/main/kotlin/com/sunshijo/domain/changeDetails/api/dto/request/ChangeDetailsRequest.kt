package com.sunshijo.domain.changeDetails.api.dto.request

import com.sunshijo.domain.changeDetails.domain.Division
import java.sql.Date

data class ChangeDetailsRequest (

    val reason: String,

    val timetableList: List<TimetableList>
)

data class TimetableList(
    val requestTimetableId: Long,
    val changeTimetableId: Long,
    val changeTeacherId: Long,
    val division: Division
)