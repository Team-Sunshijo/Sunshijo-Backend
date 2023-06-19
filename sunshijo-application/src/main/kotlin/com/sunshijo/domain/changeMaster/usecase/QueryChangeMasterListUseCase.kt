package com.sunshijo.domain.changeMaster.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeMaster.api.QueryChangeMasterList
import com.sunshijo.domain.changeMaster.api.dto.response.ChangeMasterList
import com.sunshijo.domain.changeMaster.api.dto.response.QueryChangeMasterListResponse
import com.sunshijo.domain.changeMaster.spi.QueryChangeMasterPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class QueryChangeMasterListUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val queryChangeMasterPort: QueryChangeMasterPort
) : QueryChangeMasterList {

    override fun execute(): QueryChangeMasterListResponse {

        val teacher = userSecurityPort.getCurrentUser()

        val changeMaster = queryChangeMasterPort.queryChangeMasterList(teacher.id)

        return QueryChangeMasterListResponse(
            changeMasterList = changeMaster.map {
                ChangeMasterList(
                    date = it.date,
                    reason = it.reason,
                    teacherName = teacher.name,
                    confirmed = it.confirmed
                )
            }
        )
    }
}