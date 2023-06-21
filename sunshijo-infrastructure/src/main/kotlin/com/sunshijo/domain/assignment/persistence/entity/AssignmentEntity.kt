package com.sunshijo.domain.assignment.persistence.entity

import com.sunshijo.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_assignmnet")
class AssignmentEntity(

    id: Long,

    content: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timetable_id", nullable = false)
    val dateTimetableEntity: DateTimetableEntity,

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @field:NotNull
    var content = content
}