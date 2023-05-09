package com.sunshijo.domain.schedule.persistence.entity

import com.sunshijo.domain.subject.persistence.entity.SubjectEntity
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import java.util.Date
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class ScheduleEntity (

        id: UUID,

        grade: Int,

        classNum: Int,

        period: Int,

        weekOfDate: Date,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = false)
        val teacherEntity: TeacherEntity,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "subject_id", nullable = false)
        val subjectEntity: SubjectEntity

) : BaseUUIDEntity(id) {

    @field:NotNull
    var grade = grade

    @field:NotNull
    var classNum = classNum

    @field:NotNull
    var period = period

    @field:NotNull
    var weekOfDate = weekOfDate
}