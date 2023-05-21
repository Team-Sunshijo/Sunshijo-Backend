package com.sunshijo.domain.timetable.persistence

import com.sunshijo.domain.timetable.persistence.entity.TimetableEntity
import org.springframework.data.repository.CrudRepository

interface TimetableRepository : CrudRepository<TimetableEntity, Long> {
}