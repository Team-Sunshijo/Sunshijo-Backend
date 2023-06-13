package com.sunshijo.domain.teacher.api.dto.response

data class QueryTeacherListResponse (
    val teacherList: List<TeacherResponse>
)

data class TeacherResponse(

    val teacherId: Long,

    val teacherName: String
)