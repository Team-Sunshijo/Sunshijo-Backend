package com.sunshijo.domain.schedule.persistence

import com.sunshijo.domain.schedule.persistence.entity.ScheduleEntity
import org.springframework.data.repository.CrudRepository

interface ScheduleRepository : CrudRepository<ScheduleEntity, Long> {
}