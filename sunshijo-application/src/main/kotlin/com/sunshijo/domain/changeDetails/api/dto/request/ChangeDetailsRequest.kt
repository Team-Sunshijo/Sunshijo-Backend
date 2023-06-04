package com.sunshijo.domain.changeDetails.api.dto.request

data class ChangeDetailsRequest (

    val reason: String,

    val makeUpList: List<MakeUpList>,

    val timetableList: List<TimetableList>
)

data class MakeUpList(
    val makeUpTimetableId: Long,
    val changeTeacherId: Long,
    val plan: String
)

data class TimetableList(
    val requestTimetableId: Long,
    val changeTimetableId: Long,
    val changeTeacherId: Long,
)