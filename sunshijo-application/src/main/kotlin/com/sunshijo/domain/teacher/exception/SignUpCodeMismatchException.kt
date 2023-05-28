package com.sunshijo.domain.teacher.exception

import com.sunshijo.domain.teacher.error.TeacherErrorCode
import com.sunshijo.error.SunshijoException

object SignUpCodeMismatchException : SunshijoException(
    TeacherErrorCode.SIGNUP_CODE_MIS_MATCH
)