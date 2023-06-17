package com.sunshijo.domain.changeDetails.error

import com.sunshijo.error.ErrorProperty

enum class ChangeDetailsErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    CHANGE_DETAILS_NOT_FOUND(404, "ChangeDetails Not Found")
}