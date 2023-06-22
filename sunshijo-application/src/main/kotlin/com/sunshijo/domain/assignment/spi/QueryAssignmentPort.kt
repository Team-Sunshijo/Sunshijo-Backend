package com.sunshijo.domain.assignment.spi

import com.sunshijo.domain.assignment.domain.Assignment
import com.sunshijo.domain.assignment.vo.AssignmentListVO

interface QueryAssignmentPort {

    fun queryAssignmentPort(teacherId: Long): List<AssignmentListVO>
}