package com.sunshijo.domain.teacher.persistence

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import org.springframework.data.repository.CrudRepository

interface TeacherRepository : CrudRepository<TeacherEntity, Long> {
    fun findByAccountId(accountId: String): TeacherEntity?

    fun existsByAccountId(accountId: String): Boolean
}