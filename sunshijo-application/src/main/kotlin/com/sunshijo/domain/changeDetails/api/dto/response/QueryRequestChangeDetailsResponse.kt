package com.sunshijo.domain.changeDetails.api.dto.response

import java.sql.Date

class QueryRequestChangeDetailsResponse (

    val date: Date,

    val reason: String,

    val name: String,

    val makeUpList: List<MakeUpList>,

    val timetableList: List<TimetableList>
)

data class MakeUpList(
    val date: Date,
    val period: Int,
    val grade: Int,
    val classNum: Int,
    val subject: String,
    val plan: String?,
    val changeTeacher: String
)

data class TimetableList(
    val date: Date,
    val period: Int,
    val grade: Int,
    val classNum: Int,
    val requestSubject: String,
    val changeSubject: String,
    val changeTeacher: String
)