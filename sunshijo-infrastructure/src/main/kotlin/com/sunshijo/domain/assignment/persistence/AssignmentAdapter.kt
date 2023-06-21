package com.sunshijo.domain.assignment.persistence

import com.sunshijo.domain.assignment.domain.Assignment
import com.sunshijo.domain.assignment.mapper.AssignmentMapper
import com.sunshijo.domain.assignment.spi.AssignmentPort
import com.sunshijo.global.annotation.Adapter

@Adapter
class AssignmentAdapter(
    private val assignmentMapper: AssignmentMapper,
    private val assignmentRepository: AssignmentRepository
) : AssignmentPort {

    override fun saveAssignment(assignment: Assignment) {

        assignmentRepository.save(
            assignmentMapper.toEntity(assignment)
        )
    }
}