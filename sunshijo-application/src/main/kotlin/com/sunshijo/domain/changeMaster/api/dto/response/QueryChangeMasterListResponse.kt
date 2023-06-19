package com.sunshijo.domain.changeMaster.api.dto.response

import com.sunshijo.domain.changeMaster.domain.Confirmed
import java.sql.Date

data class QueryChangeMasterListResponse (
    val changeMasterList: List<ChangeMasterList>
)

class ChangeMasterList(

    val date: Date,

    val reason: String,

    val teacherName: String,

    val confirmed: Confirmed
)