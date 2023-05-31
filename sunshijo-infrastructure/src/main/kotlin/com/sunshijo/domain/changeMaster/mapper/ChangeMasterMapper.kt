package com.sunshijo.domain.changeMaster.mapper

import com.sunshijo.domain.changeMaster.domain.ChangeMaster
import com.sunshijo.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.global.entity.GenericMapper
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ChangeMasterMapper(
    private val teacherRepository: TeacherRepository
) : GenericMapper<ChangeMaster, ChangeMasterEntity> {

    override fun toDomain(entity: ChangeMasterEntity): ChangeMaster = entity.let {
        ChangeMaster(
            id = it.id,
            reason = it.reason,
            confirmed = it.confirmed,
            date = it.date,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: ChangeMaster): ChangeMasterEntity {
        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId) ?: throw UserNotFoundException

        return ChangeMasterEntity(
            id = domain.id,
            reason = domain.reason,
            confirmed = domain.confirmed,
            date = domain.date,
            teacherEntity = teacherEntity
        )
    }

}