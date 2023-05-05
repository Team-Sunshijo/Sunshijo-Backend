package com.sunshijo.domain.teacher.mapper

import com.sunshijo.domain.teacher.domain.Teacher
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.GenericMapper
import org.springframework.stereotype.Component

@Component
class TeacherMapper : GenericMapper<Teacher, TeacherEntity> {

    override fun toDomain(entity: TeacherEntity): Teacher = entity.let {
        Teacher(
                id = it.id,
                accountId = it.accountId,
                password = it.password
        )
    }

    override fun toEntity(domain: Teacher): TeacherEntity = domain.let {
        TeacherEntity(
                id = it.id,
                accountId = it.accountId,
                password = it.password
        )
    }

}