package com.sunshijo.domain.assignment.persistence.entity

import com.sunshijo.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_assignmnet")
class AssignmentEntity (

        id: Long,

        content: String,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "timetable_id", nullable = false)
        val dateTimetableEntity: DateTimetableEntity

) : BaseIDEntity(id) {

    @field:NotNull
    var content = content
}