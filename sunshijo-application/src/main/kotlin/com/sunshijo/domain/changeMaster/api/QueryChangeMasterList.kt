package com.sunshijo.domain.changeMaster.api

import com.sunshijo.domain.changeMaster.api.dto.response.QueryChangeMasterListResponse

interface QueryChangeMasterList {

    fun execute(): QueryChangeMasterListResponse
}