package com.sunshijo.domain.changeDetails.persistence

import com.sunshijo.domain.changeDetails.persistence.entity.ChangeDetailsEntity
import org.springframework.data.repository.CrudRepository

interface ChangeDetailsRepository : CrudRepository<ChangeDetailsEntity, Long> {

    fun findAllByChangeMasterEntityId(changeMaster: Long): List<ChangeDetailsEntity>
}