package com.sunshijo.domain.changeDetails.vo

import com.sunshijo.domain.changeDetails.domain.Status
import java.sql.Date

open class ChangeDetailsManagementReplaceVO (

    val changeDetailsId: Long,

    val date: Date,

    val grade: Int,

    val classNum: Int,

    val requestSubject: String,

    val requestPeriod: Int,

    val changeSubject: String,

    val changePeriod: Int,

    val reason: String,

    val teacher: String,

    val status: Status
)