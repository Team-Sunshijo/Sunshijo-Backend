package com.sunshijo.domain.assignment.persistence.vo

import com.querydsl.core.annotations.QueryProjection
import com.sunshijo.domain.assignment.vo.AssignmentListVO
import java.sql.Date

class QueryAssignmentVO @QueryProjection constructor(

    date: Date,

    grade: Int,

    classNum: Int,

    subject: String,

    teacherName: String

) : AssignmentListVO(
    date = date,
    grade = grade,
    classNum = classNum,
    subject = subject,
    teacherName = teacherName
)