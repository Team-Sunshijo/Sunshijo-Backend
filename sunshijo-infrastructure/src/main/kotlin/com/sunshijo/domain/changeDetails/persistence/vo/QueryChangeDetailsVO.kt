package com.sunshijo.domain.changeDetails.persistence.vo

import com.querydsl.core.annotations.QueryProjection
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsVO
import java.util.*

class QueryChangeDetailsVO @QueryProjection constructor(

    requestSubject: String,

    requestDate: Date,

    requestPeriod: Int,

    requestTeacherName: String,

    replaceSubject: String,

    replaceDate: Date,

    replacePeriod: Int,

    replaceTeacherName: String

) : ChangeDetailsVO(
    requestSubject = requestSubject,
    requestDate = requestDate,
    requestPeriod = requestPeriod,
    requestTeacherName = requestTeacherName,
    replaceSubject = replaceSubject,
    replaceDate = replaceDate,
    replacePeriod = replacePeriod,
    replaceTeacherName = replaceTeacherName
)