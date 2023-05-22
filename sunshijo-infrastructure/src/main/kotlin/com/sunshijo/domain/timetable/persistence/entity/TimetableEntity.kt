package com.sunshijo.domain.timetable.persistence.entity

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Max

@Entity
@Table(name = "tbl_timetable")
class TimetableEntity (

        id: Long,

        grade: Int,

        classNum: Int,

        period: Int,

        weekOfDate: Int,

        subject: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = false)
        val teacherEntity: TeacherEntity,

) : BaseUUIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var grade = grade

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var classNum = classNum

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var period = period

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var weekOfDate = weekOfDate

    @Column(columnDefinition = "VARCHAR(30)")
    @field:NotNull
    var subject = subject
}