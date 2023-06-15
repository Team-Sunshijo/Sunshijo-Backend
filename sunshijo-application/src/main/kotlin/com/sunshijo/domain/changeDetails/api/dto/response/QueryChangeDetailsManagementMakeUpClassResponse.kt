package com.sunshijo.domain.changeDetails.api.dto.response

import com.sunshijo.domain.changeDetails.domain.Status
import java.sql.Date

data class QueryChangeDetailsManagementMakeUpClassResponse (
    val managementList: List<ManagementMakeUpClassResponse>
)

class ManagementMakeUpClassResponse(

    val requestDate: Date,

    val grade: Int,

    val classNum: Int,

    val requestSubject: String,

    val reason: String,

    val requestTeacher: String,

    val status: Status
)