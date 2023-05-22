package com.sunshijo.domain.changeMaster.persistence

import com.sunshijo.domain.changeMaster.persistence.entity.ChangeMasterEntity
import org.springframework.data.repository.CrudRepository

interface ChangeMasterRepository : CrudRepository<ChangeMasterEntity, Long> {
}