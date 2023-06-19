package com.sunshijo.domain.changeMaster.spi

import com.sunshijo.domain.changeMaster.domain.ChangeMaster

interface QueryChangeMasterPort {
    fun queryChangeMaster(changeMasterId: Long): ChangeMaster

    fun queryChangeMasterList(teacherId: Long): List<ChangeMaster>
}