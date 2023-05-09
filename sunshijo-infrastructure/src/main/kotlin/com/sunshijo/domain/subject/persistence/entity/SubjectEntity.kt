package com.sunshijo.domain.subject.persistence.entity

import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_subject")
class SubjectEntity (

        id: UUID,

        name: String

) : BaseUUIDEntity(id) {

    @field:NotNull
    var name = name
}