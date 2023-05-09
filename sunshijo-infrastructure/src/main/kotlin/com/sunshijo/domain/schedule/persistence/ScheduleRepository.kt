package com.sunshijo.domain.schedule.persistence

import com.sunshijo.domain.schedule.persistence.entity.ScheduleEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ScheduleRepository : CrudRepository<ScheduleEntity, UUID> {
}