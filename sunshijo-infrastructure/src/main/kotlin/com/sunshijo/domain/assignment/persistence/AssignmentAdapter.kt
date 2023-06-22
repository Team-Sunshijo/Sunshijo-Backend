package com.sunshijo.domain.assignment.persistence

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sunshijo.domain.assignment.domain.Assignment
import com.sunshijo.domain.assignment.mapper.AssignmentMapper
import com.sunshijo.domain.assignment.persistence.entity.QAssignmentEntity.assignmentEntity
import com.sunshijo.domain.assignment.persistence.vo.QQueryAssignmentVO
import com.sunshijo.domain.assignment.spi.AssignmentPort
import com.sunshijo.domain.assignment.vo.AssignmentListVO
import com.sunshijo.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.sunshijo.domain.teacher.persistence.entity.QTeacherEntity.teacherEntity
import com.sunshijo.global.annotation.Adapter

@Adapter
class AssignmentAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
    private val assignmentMapper: AssignmentMapper,
    private val assignmentRepository: AssignmentRepository
) : AssignmentPort {

    override fun saveAssignment(assignment: Assignment) {

        assignmentRepository.save(
            assignmentMapper.toEntity(assignment)
        )
    }

    override fun queryAssignmentPort(teacherId: Long): List<AssignmentListVO> =
        jpaQueryFactory
            .select(
                QQueryAssignmentVO(
                    dateTimetableEntity.date,
                    dateTimetableEntity.grade,
                    dateTimetableEntity.classNum,
                    dateTimetableEntity.subject,
                    teacherEntity.name
                )
            )
            .from(assignmentEntity)
            .innerJoin(assignmentEntity.teacherEntity, teacherEntity)
            .innerJoin(assignmentEntity.dateTimetableEntity, dateTimetableEntity)
            .where(assignmentEntity.teacherEntity.id.eq(teacherId))
            .fetch()
}