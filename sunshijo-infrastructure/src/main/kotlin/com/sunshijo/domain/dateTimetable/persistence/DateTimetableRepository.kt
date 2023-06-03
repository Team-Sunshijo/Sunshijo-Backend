package com.sunshijo.domain.dateTimetable.persistence

import com.sunshijo.domain.dateTimetable.persistence.entity.DateTimetableEntity
import org.springframework.data.repository.CrudRepository
import java.sql.Date

interface DateTimetableRepository : CrudRepository<DateTimetableEntity, Long> {
}