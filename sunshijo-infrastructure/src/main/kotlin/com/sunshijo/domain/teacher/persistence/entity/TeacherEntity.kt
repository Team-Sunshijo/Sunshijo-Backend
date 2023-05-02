package com.sunshijo.domain.teacher.persistence.entity

import com.sunshijo.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_teacher")
class TeacherEntity (

        id: UUID,

        accountId: String,

        password: String

) : BaseUUIDEntity(id) {

    @field:NotNull
    var accountId = accountId

    @field:NotNull
    var password = password
}