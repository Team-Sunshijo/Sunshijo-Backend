package com.sunshijo.domain.assignment.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.assignment.api.QueryMyAssignmentList
import com.sunshijo.domain.assignment.api.dto.response.AssignmentList
import com.sunshijo.domain.assignment.api.dto.response.QueryMyAssignmentListResponse
import com.sunshijo.domain.assignment.spi.QueryAssignmentPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class QueryMyAssignmentUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val queryAssignmentPort: QueryAssignmentPort
) : QueryMyAssignmentList {

    override fun execute(): QueryMyAssignmentListResponse {

        val teacher = userSecurityPort.getCurrentUser()

        val assignmentList = queryAssignmentPort.queryAssignmentPort(teacher.id)

        return QueryMyAssignmentListResponse(
            assignmentList = assignmentList.map {
                AssignmentList(
                    date = it.date,
                    grade = it.grade,
                    classNum = it.classNum,
                    subject = it.subject,
                    teacher = it.teacherName
                )
            }
        )
    }
}