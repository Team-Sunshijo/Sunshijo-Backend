package com.sunshijo.domain.changeDetails.spi

import com.sunshijo.domain.changeDetails.api.dto.request.UpdateStatus
import com.sunshijo.domain.changeDetails.domain.ChangeDetails
import com.sunshijo.domain.changeDetails.domain.MakeUpClass
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementMakeUpClassVO
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsManagementReplaceVO
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsVO
import java.sql.Date

interface QueryChangeDetailsPort {

    fun queryChangeDetails(updateStatusRequest: List<UpdateStatus>): List<ChangeDetails>

    fun queryMakeUpClass(updateStatusRequest: List<UpdateStatus>): List<MakeUpClass>

    fun queryChangeDetailsList(grade: Int, classNum: Int, today: Date): List<ChangeDetailsVO>

    fun queryChangeDetailsManagementReplaceList(teacherId: Long, status: Status): List<ChangeDetailsManagementReplaceVO>

    fun queryChangeDetailsManagementMakeUpClassList(teacherId: Long, status: Status): List<ChangeDetailsManagementMakeUpClassVO>

    fun queryChangeDetailsByMasterId(changeMasterId: Long): List<ChangeDetailsManagementReplaceVO>

    fun queryMakeUpClassByMasterId(changeMasterId: Long): List<ChangeDetailsManagementMakeUpClassVO>
}