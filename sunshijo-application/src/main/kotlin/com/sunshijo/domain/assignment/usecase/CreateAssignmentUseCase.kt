package com.sunshijo.domain.assignment.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.assignment.api.CreateAssignmentPort
import com.sunshijo.domain.assignment.api.dto.request.CreateAssignmentRequest
import com.sunshijo.domain.assignment.domain.Assignment
import com.sunshijo.domain.assignment.spi.CommandAssignmentPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class CreateAssignmentUseCase (
    private val commandAssignmentPort: CommandAssignmentPort,
    private val userSecurityPort: UserSecurityPort
) : CreateAssignmentPort {

    override fun execute(request: CreateAssignmentRequest) {

        val teacher = userSecurityPort.getCurrentUser()

        val assignment = Assignment(
            content = request.content,
            dateTimetableId = request.timetableId,
            teacherId = teacher.id
        )

        commandAssignmentPort.saveAssignment(assignment)
    }
}