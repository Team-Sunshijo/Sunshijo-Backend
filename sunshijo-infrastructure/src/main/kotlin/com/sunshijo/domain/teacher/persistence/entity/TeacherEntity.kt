package com.sunshijo.domain.teacher.persistence.entity

import com.sunshijo.global.entity.BaseIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_teacher")
class TeacherEntity(

    id: Long,

    accountId: String,

    password: String,

    name: String

) : BaseIDEntity(id) {

    @Column(columnDefinition = "VARCHAR(15)")
    @field:NotNull
    var accountId = accountId

    @field:NotNull
    var password = password

    @Column(columnDefinition = "VARCHAR(5)")
    @field:NotNull
    var name = name
}