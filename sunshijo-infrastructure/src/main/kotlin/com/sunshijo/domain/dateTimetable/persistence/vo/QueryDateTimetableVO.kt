package com.sunshijo.domain.dateTimetable.persistence.vo

import com.querydsl.core.annotations.QueryProjection
import com.sunshijo.domain.dateTimetable.vo.DateTimetableVO

class QueryDateTimetableVO @QueryProjection constructor(

    grade: Int,

    classNum: Int,

    period: Int,

    weekOfDate: Int,

    subject: String,
) : DateTimetableVO(
    grade = grade,
    classNum = classNum,
    period = period,
    weekOfDate = weekOfDate,
    subject = subject,
)