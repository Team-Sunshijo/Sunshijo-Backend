package com.sunshijo.global.error.response

import com.sunshijo.error.SunshijoException

class BaseErrorResponse (
        val status: Int,
        val message: String
) {

    companion object {
        fun of(e: SunshijoException): BaseErrorResponse {
            return BaseErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }
}