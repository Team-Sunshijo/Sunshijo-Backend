package com.sunshijo.domain.semesterTimetable.persistence

import com.sunshijo.domain.semesterTimetable.persistence.entity.SemesterTimetableEntity
import org.springframework.data.repository.CrudRepository

interface SemesterTimetableRepository : CrudRepository<SemesterTimetableEntity, Long> {
}