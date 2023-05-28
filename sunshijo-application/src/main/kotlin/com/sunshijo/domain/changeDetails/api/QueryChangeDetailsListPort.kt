package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsListResponse

interface QueryChangeDetailsListPort {

    fun execute(grade: Int, classNum: Int): QueryChangeDetailsListResponse
}