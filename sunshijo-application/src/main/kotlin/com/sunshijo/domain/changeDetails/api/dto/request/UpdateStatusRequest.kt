package com.sunshijo.domain.changeDetails.api.dto.request

import com.sunshijo.domain.changeDetails.domain.Status

data class UpdateStatusRequest (
    val updateStatusList: List<UpdateStatus>
)

class UpdateStatus(

    val changeDetailsId: Long,

    val status: Status
)