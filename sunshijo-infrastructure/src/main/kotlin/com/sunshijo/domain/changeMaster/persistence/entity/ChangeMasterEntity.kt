package com.sunshijo.domain.changeMaster.persistence.entity

import com.sunshijo.domain.changeMaster.domain.Confirmed
import com.sunshijo.domain.teacher.persistence.entity.TeacherEntity
import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "tbl_changeMaster")
class ChangeMasterEntity (

        id: Long,

        reason: String,

        confirmed: Confirmed,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "teacher_id", nullable = false)
        val teacherEntity: TeacherEntity

) : BaseIDEntity(id) {

    @field:NotNull
    val reason = reason

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val confirmed = confirmed
}