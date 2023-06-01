package com.sunshijo.domain.teacher.exception

import com.sunshijo.domain.teacher.error.TeacherErrorCode
import com.sunshijo.error.SunshijoException

object RefreshTokenNotFoundException : SunshijoException (
    TeacherErrorCode.REFRESH_TOKEN_NOT_FOUND
)