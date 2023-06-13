package com.sunshijo.domain.teacher.api

import com.sunshijo.domain.teacher.api.dto.response.QueryTeacherListResponse

interface TeacherListPort {

    fun execute(): QueryTeacherListResponse
}