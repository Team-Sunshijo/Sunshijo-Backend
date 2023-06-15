package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementMakeUpClassVO
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementReplaceVO
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsVO
import java.sql.Date

interface QueryChangeDetailsPort {

    fun queryChangeDetailsList(grade: Int, classNum: Int, today: Date): List<ChangeDetailsVO>

    fun queryChangeDetailsManagementReplaceList(teacherId: Long, status: Status): List<ChangeDetailsManagementReplaceVO>

    fun queryChangeDetailsManagementMakeUpClassList(teacherId: Long, status: Status): List<ChangeDetailsManagementMakeUpClassVO>
}