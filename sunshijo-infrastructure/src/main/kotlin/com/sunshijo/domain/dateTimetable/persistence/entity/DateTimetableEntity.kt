package com.sunshijo.domain.dateTimetable.persistence.entity

import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "tbl_dateTimetable")
class DateTimetableEntity(

    id: Long,

    year: Int,

    semester: Int,

    date: Date,

    grade: Int,

    classNum: Int,

    period: Int,

    weekOfDate: Int,

    subject: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(4)")
    @field:NotNull
    var year = year

    @Column(columnDefinition = "VARCHAR(1)")
    @field:NotNull
    var semester = semester

    @field:NotNull
    var date = date

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