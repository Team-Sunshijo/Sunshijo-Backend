package com.sunshijo.domain.changeDetails.presentation

import com.sunshijo.domain.changeDetails.api.CreateChangeDetailsPort
import com.sunshijo.domain.changeDetails.api.QueryChangeDetailsListPort
import com.sunshijo.domain.changeDetails.api.dto.request.ChangeDetailsRequest
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetable/changeDetails")
@RestController
class ChangeDetailsWebAdapter(
    private val queryChangeDetailsListPort: QueryChangeDetailsListPort,
    private val createChangeDetailsPort: CreateChangeDetailsPort
) {

    @GetMapping
    fun getChangeDetailsList(@RequestParam("grade") grade: Int, @RequestParam("class") classNum: Int): QueryChangeDetailsListResponse {
        return queryChangeDetailsListPort.execute(grade, classNum)
    }

    @PostMapping("/request")
    fun createChangeDetails(@RequestBody request: ChangeDetailsRequest) {
        createChangeDetailsPort.execute(request)
    }
}