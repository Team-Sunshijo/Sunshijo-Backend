package com.sunshijo.domain.dateTimetable.spi

import com.sunshijo.domain.dateTimetable.vo.DateTimetableVO
import java.util.Date

interface QueryDateTimetablePort {
    fun queryDateTimetableList(grade: Int, classNum: Int, monday: Date, friday: Date): List<DateTimetableVO>
}