package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.QueryChangeDetailsListPort
import com.sunshijo.domain.changeDetails.api.dto.response.DetailsResponse
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsListResponse
import com.sunshijo.domain.changeDetails.spi.QueryChangeDetailsPort
import java.sql.Date
import java.time.LocalDate

@UseCase
open class QueryChangeDetailsUseCase(
    private val queryChangeDetailsPort: QueryChangeDetailsPort
) : QueryChangeDetailsListPort {

    override fun execute(grade: Int, classNum: Int): QueryChangeDetailsListResponse {

        val today = LocalDate.now()

        val changeDetailsList = queryChangeDetailsPort.queryChangeDetailsList(grade, classNum, Date.valueOf(today))

        println(changeDetailsList)
        return QueryChangeDetailsListResponse(
            changeDetailsList = changeDetailsList
                .map {
                    DetailsResponse(
                        requestSubject = it.requestSubject,
                        requestDate = it.requestDate,
                        requestPeriod = it.requestPeriod,
                        requestTeacherName = it.requestTeacherName,
                        replaceSubject = it.replaceSubject,
                        replaceDate = it.replaceDate,
                        replacePeriod = it.replacePeriod,
                        replaceTeacherName = it.replaceTeacherName
                    )
                }
        )
    }
}