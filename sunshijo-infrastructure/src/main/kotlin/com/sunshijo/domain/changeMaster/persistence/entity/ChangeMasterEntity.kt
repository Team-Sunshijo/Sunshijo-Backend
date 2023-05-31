package com.sunshijo.domain.changeMaster.persistence.entity

import com.sunshijo.domain.changeMaster.domain.Confirmed
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "tbl_changeMaster")
class ChangeMasterEntity(

    id: Long,

    reason: String,

    confirmed: Confirmed,

    date: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @field:NotNull
    var reason = reason

    @Enumerated(EnumType.STRING)
    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    var confirmed = confirmed

    @field:NotNull
    var date = date
}