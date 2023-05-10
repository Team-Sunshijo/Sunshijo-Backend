package com.sunshijo.domain.teacher.error

import com.sunshijo.error.ErrorProperty

enum class TeacherErrorCode (
        override val status: Int,
        override val message: String
) : ErrorProperty {

    PASSWORD_MIS_MATCH(400, "Password Mis Match"),
    SIGNUP_CODE_MIS_MATCH(400, "SignUp Code Mis Match")
}