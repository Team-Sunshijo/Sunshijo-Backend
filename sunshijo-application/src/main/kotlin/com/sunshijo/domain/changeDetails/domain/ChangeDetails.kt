package com.sunshijo.domain.changeDetails.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.changeMaster.domain.ChangeMaster
import com.sunshijo.domain.dateTimetable.domain.DateTimetable
import com.sunshijo.domain.teacher.domain.Teacher

@Aggregate
class ChangeDetails(

    val id: Long,

    val status: Status,

    val division: Division,

    val changeMasterId: Long,

    val teacherId: Long,

    val requestTimetableId: Long,

    val changeTimetableId: Long

)