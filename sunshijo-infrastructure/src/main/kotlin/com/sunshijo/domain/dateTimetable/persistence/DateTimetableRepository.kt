package com.sunshijo.domain.dateTimetable.persistence

import com.sunshijo.domain.dateTimetable.persistence.entity.DateTimetableEntity
import org.springframework.data.repository.CrudRepository

interface DateTimetableRepository : CrudRepository<DateTimetableEntity, Long> {
}