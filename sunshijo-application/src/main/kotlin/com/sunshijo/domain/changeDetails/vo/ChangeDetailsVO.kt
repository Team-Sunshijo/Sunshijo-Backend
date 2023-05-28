package com.sunshijo.domain.changeDetails.vo

import java.util.Date


open class ChangeDetailsVO(
    val requestSubject: String,

    val requestDate: Date,

    val requestPeriod: Int,

    val requestTeacherName: String,

    val replaceSubject: String,

    val replaceDate: Date,

    val replacePeriod: Int,

    val replaceTeacherName: String
)