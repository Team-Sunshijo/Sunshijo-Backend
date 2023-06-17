package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.UpdateMakeUpClassStatusPort
import com.sunshijo.domain.changeDetails.api.dto.request.UpdateStatusRequest
import com.sunshijo.domain.changeDetails.spi.CommandChangeDetailsPort
import com.sunshijo.domain.changeDetails.spi.QueryChangeDetailsPort

@UseCase
open class UpdateMakeUpClassStatusUseCase (
    private val queryChangeDetailsPort: QueryChangeDetailsPort,
    private val commandChangeDetailsPort: CommandChangeDetailsPort
) : UpdateMakeUpClassStatusPort {

    override fun execute(request: UpdateStatusRequest) {
         val changeDetails = queryChangeDetailsPort.queryMakeUpClass(request.updateStatusList)

        val update = changeDetails.flatMap {
            it.updateStatus(request.updateStatusList.map { it.status })
        }

        commandChangeDetailsPort.saveMakeUpClassDetailsList(update)
    }
}