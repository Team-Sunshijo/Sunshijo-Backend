package com.sunshijo.domain.changeDetails.presentation

import com.sunshijo.domain.changeDetails.api.QueryChangeDetailsListPort
import com.sunshijo.domain.changeDetails.api.dto.response.QueryChangeDetailsListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/timetable/changeDetails")
@RestController
class ChangeDetailsWebAdapter(
    private val queryChangeDetailsListPort: QueryChangeDetailsListPort
) {

    @GetMapping
    fun getChangeDetailsList(@RequestParam("grade") grade: Int, @RequestParam("class") classNum: Int): QueryChangeDetailsListResponse {
        return queryChangeDetailsListPort.execute(grade, classNum)
    }
}