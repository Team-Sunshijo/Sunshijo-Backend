package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementMakeUpClassResponse
import com.sunshijo.domain.changeDetails.domain.Status

interface QueryChangeDetailsManagementMakeUpClassPort {

    fun execute(status: Status): QueryChangeDetailsManagementMakeUpClassResponse
}