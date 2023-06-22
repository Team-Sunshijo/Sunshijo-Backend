package com.sunshijo.domain.assignment.presentation

import com.sunshijo.domain.assignment.api.CreateAssignmentPort
import com.sunshijo.domain.assignment.api.QueryMyAssignmentList
import com.sunshijo.domain.assignment.api.dto.request.CreateAssignmentRequest
import com.sunshijo.domain.assignment.api.dto.response.QueryMyAssignmentListResponse
import com.sunshijo.domain.assignment.presentation.dto.request.WebCreateAssignmentRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/assignment")
@RestController
class AssignmentWebAdapter (
    private val createAssignmentPort: CreateAssignmentPort,
    private val queryMyAssignmentList: QueryMyAssignmentList
) {

    @PostMapping("/create")
    fun createAssignment(@RequestBody request: WebCreateAssignmentRequest) {
        createAssignmentPort.execute(CreateAssignmentRequest(
            timetableId = request.timetableId,
            content = request.content
        ))
    }

    @GetMapping("/list")
    fun queryMyAssignmentList(): QueryMyAssignmentListResponse {
        return queryMyAssignmentList.execute()
    }
}