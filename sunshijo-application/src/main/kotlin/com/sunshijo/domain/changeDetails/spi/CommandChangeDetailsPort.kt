package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.api.dto.request.TimetableList

interface CommandChangeDetailsPort {

    fun saveTimetableDetails(changeDetailsList: List<TimetableList>, changeMasterId: Long)
}