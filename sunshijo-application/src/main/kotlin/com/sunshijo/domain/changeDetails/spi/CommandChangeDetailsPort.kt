package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.api.dto.request.MakeUpList
import com.sunshijo.domain.changeDetails.api.dto.request.TimetableList
import com.sunshijo.domain.changeDetails.domain.ChangeDetails
import com.sunshijo.domain.changeDetails.domain.MakeUpClass

interface CommandChangeDetailsPort {

    fun saveChangeDetailsList(changeDetails: List<ChangeDetails>)

    fun saveMakeUpClassDetailsList(changeDetails: List<MakeUpClass>)

    fun saveTimetableDetailsList(changeDetailsList: List<TimetableList>, changeMasterId: Long)

    fun saveMakeUpDetailsList(makeUpDetailsList: List<MakeUpList>, changeMasterId: Long)
}