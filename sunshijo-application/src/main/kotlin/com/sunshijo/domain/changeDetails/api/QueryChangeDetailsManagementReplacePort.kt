package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementReplaceResponse
import com.sunshijo.domain.changeDetails.domain.Status

interface QueryChangeDetailsManagementReplacePort {

    fun execute(status: Status): QueryChangeDetailsManagementReplaceResponse
}