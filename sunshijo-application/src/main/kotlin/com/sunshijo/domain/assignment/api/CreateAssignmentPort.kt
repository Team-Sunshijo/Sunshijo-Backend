package com.sunshijo.domain.assignment.api

import com.sunshijo.domain.assignment.api.dto.request.CreateAssignmentRequest

interface CreateAssignmentPort {

    fun execute(request: CreateAssignmentRequest)
}