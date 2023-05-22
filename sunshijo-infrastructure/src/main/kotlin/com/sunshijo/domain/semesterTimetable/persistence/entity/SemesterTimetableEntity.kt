package com.sunshijo.domain.semesterTimetable.persistence.entity

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_semesterTimetable")
class SemesterTimetableEntity (

        id: Long,

        year: Int,

        semester: Int,

        grade: Int,

        classNum: Int,

        period: Int,

        weekOfDate: Int,

        subject: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = false)
        val teacherEntity: TeacherEntity,

) : BaseUUIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(4)")
    @field:NotNull
    var year = year

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var semester = semester

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