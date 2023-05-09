package com.sunshijo.domain.subject.persistence

import com.sunshijo.domain.subject.persistence.entity.SubjectEntity
import org.springframework.data.repository.CrudRepository

interface SubjectRepository : CrudRepository<SubjectEntity, Long> {

}