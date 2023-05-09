package com.sunshijo.domain.teacher.persistence.entity

import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_teacher")
class TeacherEntity (

        id: Long,

        accountId: String,

        password: String,

        name: String

) : BaseUUIDEntity(id) {

    @field:NotNull
    var accountId = accountId

    @field:NotNull
    var password = password

    @field:NotNull
    var name = name
}