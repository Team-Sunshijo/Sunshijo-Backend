package com.sunshijo.domain.changeDetails.usecase

import com.sunshijo.annotation.UseCase
import com.sunshijo.domain.changeDetails.api.CreateChangeDetailsPort
import com.sunshijo.domain.changeDetails.api.dto.request.ChangeDetailsRequest
import com.sunshijo.domain.changeDetails.api.dto.request.MakeUpList
import com.sunshijo.domain.changeDetails.domain.Division
import com.sunshijo.domain.changeDetails.domain.MakeUpClass
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeDetails.spi.CommandChangeDetailsPort
import com.sunshijo.domain.changeMaster.spi.CommandMasterPort
import com.sunshijo.domain.teacher.spi.UserSecurityPort
import java.sql.Date
import java.time.LocalDate

@UseCase
open class CreateChangeDetailsUseCase (
    private val userSecurityPort: UserSecurityPort,
    private val commandChangeDetailsPort: CommandChangeDetailsPort,
    private val commandMasterPort: CommandMasterPort,
) : CreateChangeDetailsPort {

    override fun execute(request: ChangeDetailsRequest) {

        val date = LocalDate.now()

        val teacher = userSecurityPort.getCurrentUser()

        val changeMaster = commandMasterPort.saveCommandMaster(teacher.id, request.reason, date = Date.valueOf(date))

        commandChangeDetailsPort.saveMakeUpDetailsList(request.makeUpList, changeMaster.id)

        commandChangeDetailsPort.saveTimetableDetailsList(request.timetableList, changeMaster.id)


//        val domain = request.makeUpList.map {
//            MakeUpClass(
//                status = Status.REQUESTING,
//                division = Division.MAKEUPCLASS,
//                changeMasterId = changeMaster.id,
//                teacherId = teacher.id,
//                requestTimetableId = it.makeUpTimetableId
//            )
//        }
//
//        commandChangeDetailsPort.saveChangeDetailsList(domain)
    }
}