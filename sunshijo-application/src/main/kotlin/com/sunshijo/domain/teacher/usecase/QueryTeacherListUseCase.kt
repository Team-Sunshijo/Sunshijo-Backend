package com.sunshijo.domain.teacher.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.teacher.api.TeacherListPort
import com.sunshijo.domain.teacher.api.dto.response.QueryTeacherListResponse
import com.sunshijo.domain.teacher.api.dto.response.TeacherResponse
import com.sunshijo.domain.teacher.spi.QueryUserPort

@UseCase
open class QueryTeacherListUseCase (
    private val queryUserPort: QueryUserPort
) : TeacherListPort {

    override fun execute(): QueryTeacherListResponse {

        val teacherList = queryUserPort.queryTeacher()

        return QueryTeacherListResponse(
            teacherList = teacherList
                .map {
                    TeacherResponse(
                        teacherId = it.id,
                        teacherName = it.name
                    )
                }
        )
    }
}