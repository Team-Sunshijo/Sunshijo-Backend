package com.sunshijo.domain.changeDetails.api.dto.response

import com.sunshijo.domain.changeDetails.domain.Status
import java.sql.Date

data class QueryChangeDetailsManagementReplaceResponse(
    val managementList: List<ManagementReplaceResponse>
)

class ManagementReplaceResponse(

    val requestDate: Date,

    val grade: Int,

    val classNum: Int,

    val requestSubject: String,

    val changeSubject: String?,

    val reason: String,

    val requestTeacher: String,

    val status: Status
)