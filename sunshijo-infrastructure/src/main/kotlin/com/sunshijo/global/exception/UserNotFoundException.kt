package com.sunshijo.global.exception

import com.sunshijo.error.SunshijoException
import com.sunshijo.global.error.ErrorCode

object UserNotFoundException : SunshijoException(
    ErrorCode.USER_NOT_FOUND
)