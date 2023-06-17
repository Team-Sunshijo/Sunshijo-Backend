package com.sunshijo.domain.changeDetails.exception

import com.sunshijo.domain.changeDetails.error.ChangeDetailsErrorCode
import com.sunshijo.error.SunshijoException

object ChangeDetailsNotFoundException : SunshijoException (
    ChangeDetailsErrorCode.CHANGE_DETAILS_NOT_FOUND
)