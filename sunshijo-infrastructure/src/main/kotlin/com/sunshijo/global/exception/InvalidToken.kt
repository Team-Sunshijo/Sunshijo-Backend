package com.sunshijo.global.exception

import com.sunshijo.error.SunshijoException
import com.sunshijo.global.error.ErrorCode

object InvalidToken : SunshijoException(
    ErrorCode.INVALID_TOKEN
)