package com.sunshijo.domain.dateTimetable.error

import com.sunshijo.error.ErrorProperty

enum class DateTimetableErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    TIMETABLE_NOT_FOUND(404, "Timetable Not Found")
}