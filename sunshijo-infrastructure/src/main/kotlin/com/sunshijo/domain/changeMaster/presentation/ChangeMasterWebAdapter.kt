package com.sunshijo.domain.changeMaster.presentation

import com.sunshijo.domain.changeMaster.api.QueryChangeMasterList
import com.sunshijo.domain.changeMaster.api.dto.response.QueryChangeMasterListResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/request")
@RestController
class ChangeMasterWebAdapter(
    private val queryChangeMasterList: QueryChangeMasterList
) {

    @GetMapping("/list")
    fun queryChangeMasterList(): QueryChangeMasterListResponse {
        return queryChangeMasterList.execute()
    }
}