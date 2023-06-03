package com.sunshijo.domain.dateTimetable.persistence

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sunshijo.domain.changeDetails.api.dto.request.ChangeDetailsMakeUpRequest
import com.sunshijo.domain.changeDetails.api.dto.request.MakeUpList
import com.sunshijo.domain.dateTimetable.domain.DateTimetable
import com.sunshijo.domain.dateTimetable.mapper.DateTimetableMapper
import com.sunshijo.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.sunshijo.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.sunshijo.domain.dateTimetable.persistence.vo.QueryDateTimetableVO
import com.sunshijo.domain.dateTimetable.spi.DateTimetablePort
import com.sunshijo.global.annotation.Adapter
import java.sql.Date

@Adapter
class DateTimetableAdapter(
    private val jpaQueryFactory: JPAQueryFactory,
    private val dateTimetableRepository: DateTimetableRepository,
    private val dateTimetableMapper: DateTimetableMapper
) : DateTimetablePort {

    override fun queryDateTimetableList(grade: Int, classNum: Int, monday: Date, friday: Date): List<QueryDateTimetableVO> =
        jpaQueryFactory
            .select(
                QQueryDateTimetableVO(
                    dateTimetableEntity.grade,
                    dateTimetableEntity.classNum,
                    dateTimetableEntity.period,
                    dateTimetableEntity.weekOfDate,
                    dateTimetableEntity.subject
                )
            )
            .from(dateTimetableEntity)
            .where(
                dateTimetableEntity.grade.eq(grade)
                    .and(dateTimetableEntity.classNum.eq(classNum))
                    .and(dateTimetableEntity.date.between(monday, friday))
            )
            .orderBy(dateTimetableEntity.weekOfDate.asc(), dateTimetableEntity.period.asc())
            .fetch()
}
