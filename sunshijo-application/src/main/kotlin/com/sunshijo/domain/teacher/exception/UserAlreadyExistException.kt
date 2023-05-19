package com.sunshijo.domain.teacher.exception

import com.sunshijo.domain.teacher.error.TeacherErrorCode
import com.sunshijo.error.SunshijoException

object UserAlreadyExistException : SunshijoException (
        TeacherErrorCode.USER_ALREADY_EXIST
)