package com.sunshijo.domain.assignment.spi

import com.sunshijo.domain.assignment.domain.Assignment

interface CommandAssignmentPort {

    fun saveAssignment(assignment: Assignment)
}