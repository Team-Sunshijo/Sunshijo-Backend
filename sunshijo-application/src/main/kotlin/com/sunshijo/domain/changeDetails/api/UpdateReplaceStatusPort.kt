package com.sunshijo.domain.changeDetails.api

import com.sunshijo.domain.changeDetails.api.dto.request.UpdateStatusRequest

interface UpdateReplaceStatusPort {

    fun execute(request: UpdateStatusRequest)
}