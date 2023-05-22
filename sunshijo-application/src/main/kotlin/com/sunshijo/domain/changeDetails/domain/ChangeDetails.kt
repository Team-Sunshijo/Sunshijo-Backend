package com.sunshijo.domain.changeDetails.domain

import com.sunshijo.annotation.Aggregate
import com.sunshijo.domain.changeMaster.domain.ChangeMaster
import com.sunshijo.domain.dateTimetable.domain.DateTimetable
import com.sunshijo.domain.teacher.domain.Teacher

@Aggregate
class ChangeDetails (

        val id: Long,

        val status: Status,

        val division: Division,

        val changeMaster: ChangeMaster,

        val teacher: Teacher,

        val requestTimetable: DateTimetable,

        val changeTimetable: DateTimetable

)