package com.sunshijo.domain.assignment.vo

import java.sql.Date

open class AssignmentListVO (
    val date: Date,

    val grade: Int,

    val classNum: Int,

    val subject: String,

    val teacherName: String
)