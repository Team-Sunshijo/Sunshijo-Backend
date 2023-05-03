package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TeacherRepository : CrudRepository<TeacherEntity, UUID> {
    fun findByAccountId(accountId: String): TeacherEntity?
}