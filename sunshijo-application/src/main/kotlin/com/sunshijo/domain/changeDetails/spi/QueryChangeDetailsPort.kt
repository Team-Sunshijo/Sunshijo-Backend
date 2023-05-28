package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.vo.ChangeDetailsVO
import java.sql.Date

interface QueryChangeDetailsPort {

    fun queryChangeDetailsList(grade: Int, classNum: Int, today: Date): List<ChangeDetailsVO>
}