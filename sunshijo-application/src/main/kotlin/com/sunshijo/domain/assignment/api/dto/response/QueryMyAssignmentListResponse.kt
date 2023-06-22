package com.sunshijo.domain.assignment.api.dto.response

import java.sql.Date

class QueryMyAssignmentListResponse (
    val assignmentList: List<AssignmentList>
)

class AssignmentList (
    val date: Date,

    val grade: Int,

    val classNum: Int,

    val subject: String,

    val teacher: String
)