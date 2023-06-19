package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.QueryRequestChangeDetailsPort
import com.sunshijo.domain.changeDetails.api.dto.response.MakeUpList
import com.sunshijo.domain.changeDetails.api.dto.response.QueryRequestChangeDetailsResponse
import com.sunshijo.domain.changeDetails.api.dto.response.TimetableList
import com.sunshijo.domain.changeDetails.spi.QueryChangeDetailsPort
import com.sunshijo.domain.changeMaster.spi.QueryChangeMasterPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort

@UseCase
open class QueryRequestChangeDetailsUseCase(
    private val queryChangeDetailsPort: QueryChangeDetailsPort,
    private val queryChangeMasterPort: QueryChangeMasterPort,
    private val userSecurityPort: UserSecurityPort
) : QueryRequestChangeDetailsPort {

    override fun execute(changeMasterId: Long): QueryRequestChangeDetailsResponse {

        val teacher = userSecurityPort.getCurrentUser()
        val detailsMaster = queryChangeMasterPort.queryChangeMaster(changeMasterId)
        val makeUpClass = queryChangeDetailsPort.queryMakeUpClassByMasterId(changeMasterId)
        val replace = queryChangeDetailsPort.queryChangeDetailsByMasterId(changeMasterId)

        return QueryRequestChangeDetailsResponse(
            date = detailsMaster.date,
            reason = detailsMaster.reason,
            name = teacher.name,
            makeUpList = makeUpClass.map {
                MakeUpList(
                    date = it.date,
                    period = it.period,
                    grade = it.grade,
                    classNum = it.classNum,
                    subject = it.requestSubject,
                    plan = null,
                    changeTeacher = it.teacher
                )
            },
            timetableList = replace.map {
                TimetableList(
                    date = it.date,
                    period = it.changePeriod,
                    grade = it.grade,
                    classNum = it.classNum,
                    requestSubject = it.requestSubject,
                    changeSubject = it.changeSubject,
                    changeTeacher = it.teacher
                )
            }
        )
    }
}