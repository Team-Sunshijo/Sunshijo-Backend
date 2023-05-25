package com.sunshijo.domain.changeDetails.persistence.entity

import com.sunshijo.domain.changeDetails.domain.Division
import com.sunshijo.domain.changeDetails.domain.Status
import com.sunshijo.domain.changeMaster.persistence.entity.ChangeMasterEntity
import com.sunshijo.domain.dateTimetable.persistence.entity.DateTimetableEntity
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_changeDetails")
class ChangeDetailsEntity (

        id: Long,

        status: Status,

        division: Division,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "master_id", nullable = false)
        val changeMasterEntity: ChangeMasterEntity,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = true)
        val teacherEntity: TeacherEntity,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "requestTimetable_id", nullable = false)
        val requestTimetableEntity: DateTimetableEntity,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "changeTimetable_id", nullable = true)
        val changeTimetableEntity: DateTimetableEntity

) : BaseIDEntity(id) {

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(10)")
        var status = status

        @field:NotNull
        @Column(columnDefinition = "VARCHAR(11)")
        var division = division
}