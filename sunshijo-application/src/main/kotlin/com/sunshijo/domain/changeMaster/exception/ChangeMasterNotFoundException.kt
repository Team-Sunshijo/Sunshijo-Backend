package com.sunshijo.domain.changeMaster.exception

import com.sunshijo.domain.changeMaster.error.ChangeMasterErrorCode
import com.sunshijo.error.SunshijoException

object ChangeMasterNotFoundException : SunshijoException(
    ChangeMasterErrorCode.CHANGE_MASTER_NOT_FOUND
)