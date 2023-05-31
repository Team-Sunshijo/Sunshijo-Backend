package com.sunshijo.domain.changeDetails.persistence

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sunshijo.domain.changeDetails.api.dto.request.TimetableList
import com.sunshijo.domain.changeDetails.domain.ChangeDetails
import com.sunshijo.domain.changeDetails.domain.Status.REQUESTING
import com.sunshijo.domain.changeDetails.mapper.ChangeDetailsMapper
import com.sunshijo.domain.changeDetails.persistence.entity.QChangeDetailsEntity.changeDetailsEntity
import com.sunshijo.domain.changeDetails.persistence.vo.QQueryChangeDetailsVO
import com.sunshijo.domain.changeDetails.spi.ChangeDetailsPort
import com.sunshijo.domain.changeDetails.vo.ChangeDetailsVO
import com.sunshijo.domain.changeMaster.domain.Confirmed.ACCEPT
import com.sunshijo.domain.changeMaster.persistence.entity.QChangeMasterEntity.changeMasterEntity
import com.sunshijo.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.sunshijo.global.annotation.Adapter
import java.sql.Date

@Adapter
class ChangeDetailsAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
    private val changeDetailsRepository: ChangeDetailsRepository,
    private val changeDetailsMapper: ChangeDetailsMapper
) : ChangeDetailsPort {

    override fun queryChangeDetailsList(grade: Int, classNum: Int, today: Date): List<ChangeDetailsVO> =
        jpaQueryFactory
            .select(
                QQueryChangeDetailsVO(
                    changeDetailsEntity.requestTimetableEntity.subject,
                    changeDetailsEntity.requestTimetableEntity.date,
                    changeDetailsEntity.requestTimetableEntity.period,
                    changeDetailsEntity.requestTimetableEntity.teacherEntity.name,
                    changeDetailsEntity.changeTimetableEntity.subject,
                    changeDetailsEntity.changeTimetableEntity.date,
                    changeDetailsEntity.changeTimetableEntity.period,
                    changeDetailsEntity.changeTimetableEntity.teacherEntity.name
                )
            )
            .from(changeDetailsEntity)
            .innerJoin(changeDetailsEntity.changeTimetableEntity, dateTimetableEntity)
            .innerJoin(changeDetailsEntity.changeMasterEntity, changeMasterEntity)
            .on(changeMasterEntity.confirmed.eq(ACCEPT))
            .where(
                changeDetailsEntity.requestTimetableEntity.date.eq(today)
                    .or(changeDetailsEntity.changeTimetableEntity.date.eq(today))
                    .and(dateTimetableEntity.grade.eq(grade))
                    .and(dateTimetableEntity.classNum.eq(classNum))
                    .and(changeMasterEntity.confirmed.eq(ACCEPT))
            )
            .orderBy(dateTimetableEntity.period.asc())
            .fetch()

    override fun saveTimetableDetails(changeDetailsList: List<TimetableList>, changeMasterId: Long) {
        val changeDetailsEntities = changeDetailsList.map {
            changeDetailsMapper.toEntity(
                ChangeDetails(
                    status = REQUESTING,
                    division = it.division,
                    changeMasterId = changeMasterId,
                    teacherId = it.changeTeacherId,
                    requestTimetableId = it.requestTimetableId,
                    changeTimetableId = it.changeTimetableId
                )
            )
        }
        changeDetailsRepository.saveAll(changeDetailsEntities)
    }
}