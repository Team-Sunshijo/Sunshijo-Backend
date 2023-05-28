package com.sunshijo.domain.changeDetails.api.dto.response

import java.util.*

class QueryChangeDetailsListResponse(
    val changeDetailsList: List<DetailsResponse>
)

class DetailsResponse(

    val requestSubject: String,

    val requestDate: Date,

    val requestPeriod: Int,

    val requestTeacherName: String,

    val replaceSubject: String,

    val replaceDate: Date,

    val replacePeriod: Int,

    val replaceTeacherName: String
)