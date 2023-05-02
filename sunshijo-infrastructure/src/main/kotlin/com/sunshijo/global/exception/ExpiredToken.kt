package com.sunshijo.global.exception

import com.sunshijo.error.SunshijoException
import com.sunshijo.global.error.ErrorCode

object ExpiredToken : SunshijoException (
        ErrorCode.EXPIRED_TOKEN
)