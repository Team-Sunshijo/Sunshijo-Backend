package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.api.dto.request.MakeUpList
import com.sunshijo.domain.changeDetails.api.dto.request.TimetableList
import com.sunshijo.domain.dateTimetable.domain.DateTimetable

interface CommandChangeDetailsPort {

    fun saveTimetableDetails(changeDetailsList: List<TimetableList>, changeMasterId: Long)

    fun saveMakeUpDetails(makeUpDetailsList: List<MakeUpList>, changeMasterId: Long)
}