package com.sunshijo.domain.assignment.mapper

import com.sunshijo.domain.assignment.domain.Assignment
import com.sunshijo.domain.assignment.persistence.AssignmentRepository
import com.sunshijo.domain.assignment.persistence.entity.AssignmentEntity
import com.sunshijo.domain.dateTimetable.exception.DateTimetableNotFoundException
import com.sunshijo.domain.dateTimetable.persistence.DateTimetableRepository
import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.global.entity.GenericMapper
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AssignmentMapper(
    private val assignmentRepository: AssignmentRepository,
    private val dateTimetableRepository: DateTimetableRepository,
    private val teacherRepository: TeacherRepository
) : GenericMapper<Assignment, AssignmentEntity> {

    override fun toDomain(entity: AssignmentEntity): Assignment = entity.let {
        Assignment(
            id = it.id,
            content = it.content,
            dateTimetableId = it.dateTimetableEntity.id,
            teacherId = it.teacherEntity.id
        )
    }

    override fun toEntity(domain: Assignment): AssignmentEntity = domain.let {

        val dateTimetableEntity =
            dateTimetableRepository.findByIdOrNull(domain.dateTimetableId) ?: throw DateTimetableNotFoundException

        val teacherEntity = teacherRepository.findByIdOrNull(domain.teacherId) ?: throw UserNotFoundException

        AssignmentEntity(
            id = it.id,
            content = it.content,
            dateTimetableEntity = dateTimetableEntity,
            teacherEntity = teacherEntity
        )
    }
}