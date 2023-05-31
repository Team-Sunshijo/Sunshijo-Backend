package com.sunshijo.domain.dateTimetable.spi

import com.sunshijo.domain.dateTimetable.domain.DateTimetable
import com.sunshijo.domain.dateTimetable.vo.DateTimetableVO
import java.sql.Date

interface QueryDateTimetablePort {
    fun queryDateTimetableList(grade: Int, classNum: Int, monday: Date, friday: Date): List<DateTimetableVO>

    fun queryChangeTimetable(grade: Int, classNum: Int, date: Date, period: Int): DateTimetable
}