package com.sunshijo.domain.dateTimetable.exception

import com.sunshijo.domain.dateTimetable.error.DateTimetableErrorCode
import com.sunshijo.error.SunshijoException

object DateTimetableNotFoundException : SunshijoException(
    DateTimetableErrorCode.TIMETABLE_NOT_FOUND
)