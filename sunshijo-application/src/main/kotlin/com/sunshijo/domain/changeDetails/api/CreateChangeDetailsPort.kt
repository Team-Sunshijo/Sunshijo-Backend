package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.request.ChangeDetailsRequest

interface CreateChangeDetailsPort {

    fun execute(request: ChangeDetailsRequest)
}