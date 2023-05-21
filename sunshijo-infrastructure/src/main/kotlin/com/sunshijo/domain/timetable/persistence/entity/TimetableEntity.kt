package com.sunshijo.domain.timetable.persistence.entity

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import java.util.Date
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "tbl_timetable")
class TimetableEntity (

        id: Long,

        grade: Int,

        classNum: Int,

        period: Int,

        weekOfDate: Date,

        subject: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = false)
        val teacherEntity: TeacherEntity,

) : BaseUUIDEntity(id) {

    @field:NotNull
    var grade = grade

    @field:NotNull
    var classNum = classNum

    @field:NotNull
    var period = period

    @field:NotNull
    var weekOfDate = weekOfDate

    @field:NotNull
    var subject = subject
}