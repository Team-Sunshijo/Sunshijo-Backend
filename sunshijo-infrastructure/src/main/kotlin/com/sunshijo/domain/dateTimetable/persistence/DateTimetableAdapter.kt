package com.sunshijo.domain.dateTimetable.persistence

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sunshijo.domain.dateTimetable.persistence.entity.QDateTimetableEntity.dateTimetableEntity
import com.sunshijo.domain.dateTimetable.persistence.vo.QQueryDateTimetableVO
import com.sunshijo.domain.dateTimetable.persistence.vo.QueryDateTimetableVO
import com.sunshijo.domain.dateTimetable.spi.DateTimetablePort
import com.sunshijo.global.annotation.Adapter
import java.util.*

@Adapter
class DateTimetableAdapter(
        private val jpaQueryFactory: JPAQueryFactory,
) : DateTimetablePort {

    override fun queryDateTimetableList(grade: Int, classNum: Int, monday: Date, friday: Date): List<QueryDateTimetableVO> =
            jpaQueryFactory
                    .select(QQueryDateTimetableVO(
                            dateTimetableEntity.grade,
                            dateTimetableEntity.classNum,
                            dateTimetableEntity.period,
                            dateTimetableEntity.weekOfDate,
                            dateTimetableEntity.subject
                    ))
                    .from(dateTimetableEntity)
                    .where(
                            dateTimetableEntity.grade.eq(grade)
                                    .and(dateTimetableEntity.classNum.eq(classNum))
                                    .and(dateTimetableEntity.date.between(monday, friday))
                    )
                    .orderBy(dateTimetableEntity.weekOfDate.asc(), dateTimetableEntity.period.asc())
                    .fetch()
}
