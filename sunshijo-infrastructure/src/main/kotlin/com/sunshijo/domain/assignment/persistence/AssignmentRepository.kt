package com.sunshijo.domain.assignment.persistence

import com.sunshijo.domain.assignment.persistence.entity.AssignmentEntity
import org.springframework.data.repository.CrudRepository

interface AssignmentRepository : CrudRepository<AssignmentEntity, Long> {
}