package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.QueryChangeDetailsManagementMakeUpClassPort
import com.sunshijo.domain.changeDetails.api.dto.response.ManagementMakeUpClassResponse
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementMakeUpClassResponse
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.spi.QueryChangeDetailsPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class QueryChangeDetailsManagementMakeUpClassUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val queryChangeDetailsPort: QueryChangeDetailsPort
) : QueryChangeDetailsManagementMakeUpClassPort {

    override fun execute(status: Status): QueryChangeDetailsManagementMakeUpClassResponse {

        val teacher = userSecurityPort.getCurrentUser()

        val managementList = queryChangeDetailsPort.queryChangeDetailsManagementMakeUpClassList(teacher.id, status)

        return QueryChangeDetailsManagementMakeUpClassResponse(
            managementList = managementList.map {
                ManagementMakeUpClassResponse(
                    requestDate = it.date,
                    grade = it.grade,
                    classNum = it.classNum,
                    requestSubject = it.requestSubject,
                    reason = it.reason,
                    requestTeacher = it.teacher,
                    status = it.status
                )
            }
        )

    }
}