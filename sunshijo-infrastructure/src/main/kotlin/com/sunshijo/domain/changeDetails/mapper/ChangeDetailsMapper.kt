package com.sunshijo.domain.changeDetails.mapper

import com.sunshijo.domain.changeDetails.domain.ChangeDetails
import com.sunshijo.domain.changeDetails.domain.MakeUpClass
import com.sunshijo.domain.changeDetails.persistence.entity.ChangeDetailsEntity
import com.sunshijo.domain.changeMaster.exception.ChangeMasterNotFoundException
import com.sunshijo.domain.changeMaster.persistence.ChangeMasterRepository
import com.sunshijo.domain.dateTimetable.exception.DateTimetableNotFoundException
import com.sunshijo.domain.dateTimetable.persistence.DateTimetableRepository
import com.sunshijo.domain.teacher.persistence.TeacherRepository
import com.sunshijo.global.entity.GenericMapper
import com.sunshijo.global.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ChangeDetailsMapper(
    private val changeMasterRepository: ChangeMasterRepository,
    private val teacherRepository: TeacherRepository,
    private val dateTimetableRepository: DateTimetableRepository
) : GenericMapper<ChangeDetails, ChangeDetailsEntity> {

    override fun toDomain(entity: ChangeDetailsEntity): ChangeDetails = entity.let {
        ChangeDetails(
            id = it.id,
            status = it.status,
            division = it.division,
            changeMasterId = it.changeMasterEntity.id,
            teacherId = it.teacherEntity.id,
            requestTimetableId = it.requestTimetableEntity.id,
            changeTimetableId = it.changeTimetableEntity!!.id
        )
    }

    override fun toEntity(domain: ChangeDetails): ChangeDetailsEntity {

        val changeMaster =
            changeMasterRepository.findByIdOrNull(domain.changeMasterId) ?: throw ChangeMasterNotFoundException

        val teacher = teacherRepository.findByIdOrNull(domain.teacherId) ?: throw UserNotFoundException

        val requestTimetable =
            dateTimetableRepository.findByIdOrNull(domain.requestTimetableId) ?: throw DateTimetableNotFoundException

        val changeTimetable =
            dateTimetableRepository.findByIdOrNull(domain.changeTimetableId) ?: throw DateTimetableNotFoundException

        return ChangeDetailsEntity(
            id = domain.id,
            status = domain.status,
            division = domain.division,
            changeMasterEntity = changeMaster,
            teacherEntity = teacher,
            requestTimetableEntity = requestTimetable,
            changeTimetableEntity = changeTimetable
        )
    }

    fun makeUpClassToEntity(domain: MakeUpClass): ChangeDetailsEntity {

        val changeMaster =
            changeMasterRepository.findByIdOrNull(domain.changeMasterId) ?: throw ChangeMasterNotFoundException

        val teacher = teacherRepository.findByIdOrNull(domain.teacherId) ?: throw UserNotFoundException

        val requestTimetable =
            dateTimetableRepository.findByIdOrNull(domain.requestTimetableId) ?: throw DateTimetableNotFoundException

        return ChangeDetailsEntity(
            id = domain.id,
            status = domain.status,
            division = domain.division,
            changeMasterEntity = changeMaster,
            teacherEntity = teacher,
            requestTimetableEntity = requestTimetable,
            changeTimetableEntity = null
        )
    }
}