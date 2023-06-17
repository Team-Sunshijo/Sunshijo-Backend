package com.sunshijo.domain.changeDetails.presentation

import com.sunshijo.domain.changeDetails.api.*
import com.sunshijo.domain.changeDetails.api.dto.request.ChangeDetailsRequest
import com.sunshijo.domain.changeDetails.api.dto.request.UpdateStatusRequest
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsListResponse
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementMakeUpClassResponse
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsManagementReplaceResponse
import com.sunshijo.domain.changeDetails.domain.Status
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetable/changeDetails")
@RestController
class ChangeDetailsWebAdapter(
    private val queryChangeDetailsListPort: QueryChangeDetailsListPort,
    private val createChangeDetailsPort: CreateChangeDetailsPort,
    private val queryChangeDetailsManagementReplacePort: QueryChangeDetailsManagementReplacePort,
    private val queryChangeDetailsManagementMakeUpClassPort: QueryChangeDetailsManagementMakeUpClassPort,
    private val updateStatusPort: UpdateReplaceStatusPort,
    private val updateMakeUpClassStatusPort: UpdateMakeUpClassStatusPort
) {

    @GetMapping
    fun getChangeDetailsList(@RequestParam("grade") grade: Int, @RequestParam("class") classNum: Int): QueryChangeDetailsListResponse {
        return queryChangeDetailsListPort.execute(grade, classNum)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/request")
    fun createChangeDetails(@RequestBody request: ChangeDetailsRequest) {
        createChangeDetailsPort.execute(request)
    }

    @GetMapping("/replace")
    fun queryChangeDetailsReplaceManagement(@RequestParam status: String): QueryChangeDetailsManagementReplaceResponse {
        return queryChangeDetailsManagementReplacePort.execute(Status.valueOf(status))
    }

    @GetMapping("/makeUpClass")
    fun queryChangeDetailsMakeUpClassManagement(@RequestParam status: String): QueryChangeDetailsManagementMakeUpClassResponse {
        return queryChangeDetailsManagementMakeUpClassPort.execute(Status.valueOf(status))
    }

    @PutMapping("/update")
    fun updateStatus(@RequestBody request: UpdateStatusRequest) {
        updateStatusPort.execute(request)
    }

    @PutMapping("/makeUpClassUpdate")
    fun updateMakeUpClassStatus(@RequestBody request: UpdateStatusRequest) {
        updateMakeUpClassStatusPort.execute(request)
    }
}