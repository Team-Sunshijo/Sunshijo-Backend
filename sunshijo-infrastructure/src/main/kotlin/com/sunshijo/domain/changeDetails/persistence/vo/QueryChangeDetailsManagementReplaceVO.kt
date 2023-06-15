package com.sunshijo.domain.changeDetails.persistence.vo

import com.querydsl.core.annotations.QueryProjection
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementReplaceVO
import java.sql.Date

class QueryChangeDetailsManagementReplaceVO @QueryProjection constructor(

    changeDetailsId: Long,

    date: Date,

    grade: Int,

    classNum: Int,

    requestSubject: String,

    changeSubject: String,

    reason: String,

    teacher: String,

    status: Status
) : ChangeDetailsManagementReplaceVO(
    changeDetailsId = changeDetailsId,
    date = date,
    grade = grade,
    classNum = classNum,
    requestSubject = requestSubject,
    changeSubject = changeSubject,
    reason = reason,
    teacher = teacher,
    status = status
)