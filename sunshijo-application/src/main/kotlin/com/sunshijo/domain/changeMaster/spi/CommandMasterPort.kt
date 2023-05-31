package com.sunshijo.domain.changeMaster.spi

import com.sunshijo.domain.changeMaster.domain.ChangeMaster
import java.sql.Date

interface CommandMasterPort {
    fun saveCommandMaster(teacherId: Long, reason: String, date: Date): ChangeMaster
}