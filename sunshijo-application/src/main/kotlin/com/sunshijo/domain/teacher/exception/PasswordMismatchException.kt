package com.sunshijo.domain.teacher.exception

import com.sunshijo.domain.teacher.error.TeacherErrorCode
import com.sunshijo.error.SunshijoException

object PasswordMismatchException : SunshijoException(
    TeacherErrorCode.PASSWORD_MIS_MATCH
)