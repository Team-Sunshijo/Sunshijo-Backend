package com.sunshijo.domain.assignment.api

import com.sunshijo.domain.assignment.api.dto.response.QueryMyAssignmentListResponse

interface QueryMyAssignmentList {

    fun execute(): QueryMyAssignmentListResponse
}