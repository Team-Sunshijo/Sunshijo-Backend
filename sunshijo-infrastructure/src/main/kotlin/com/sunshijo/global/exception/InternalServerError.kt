package com.sunshijo.global.exception

import com.sunshijo.error.SunshijoException
import com.sunshijo.global.error.ErrorCode

object InternalServerError : SunshijoException(
    ErrorCode.INTERNAL_SERVER_ERROR
)