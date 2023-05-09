package com.sunshijo.domain.subject.persistence

import com.sunshijo.domain.subject.persistence.entity.SubjectEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SubjectRepository : CrudRepository<SubjectEntity, UUID> {

}