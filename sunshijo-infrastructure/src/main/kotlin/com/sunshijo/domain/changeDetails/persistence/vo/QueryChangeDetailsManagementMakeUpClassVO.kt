package com.sunshijo.domain.changeDetails.persistence.vo

import com.querydsl.core.annotations.QueryProjection
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementMakeUpClassVO
import java.sql.Date

class QueryChangeDetailsManagementMakeUpClassVO @QueryProjection constructor(

    date: Date,

    grade: Int,

    classNum: Int,

    requestSubject: String,

    reason: String,

    teacher: String,

    status: Status
) : ChangeDetailsManagementMakeUpClassVO(
    date = date,
    grade = grade,
    classNum = classNum,
    requestSubject = requestSubject,
    reason = reason,
    teacher = teacher,
    status = status
)