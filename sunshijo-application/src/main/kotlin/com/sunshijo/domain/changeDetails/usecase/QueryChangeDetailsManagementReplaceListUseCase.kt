package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.QueryChangeDetailsManagementReplacePort
import com.sunshijo.domain.changeDetails.api.dto.response.ManagementReplaceResponse
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementReplaceResponse
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.spi.QueryChangeDetailsPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class QueryChangeDetailsManagementReplaceListUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val queryChangeDetailsPort: QueryChangeDetailsPort
) : QueryChangeDetailsManagementReplacePort {

    override fun execute(status: Status): QueryChangeDetailsManagementReplaceResponse {

        val teacher = userSecurityPort.getCurrentUser()

        val managementReplaceList = queryChangeDetailsPort.queryChangeDetailsManagementReplaceList(teacher.id, status)

        return QueryChangeDetailsManagementReplaceResponse(
            managementList = managementReplaceList.map {
                ManagementReplaceResponse(
                    id = it.changeDetailsId,
                    requestDate = it.date,
                    grade = it.grade,
                    classNum = it.classNum,
                    requestSubject = it.requestSubject,
                    requestPeriod = it.requestPeriod,
                    changeSubject = it.changeSubject,
                    changePeriod = it.changePeriod,
                    reason = it.reason,
                    requestTeacher = it.teacher,
                    status = it.status
                )
            }
        )
    }
}