package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.response.QueryRequestChangeDetailsResponse

interface QueryRequestChangeDetailsPort {

    fun execute(changeMasterId: Long): QueryRequestChangeDetailsResponse
}