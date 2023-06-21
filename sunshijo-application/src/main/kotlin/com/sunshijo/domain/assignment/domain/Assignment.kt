package com.sunshijo.domain.assignment.domain

import com.sunshijo.annotation.Aggregate

@Aggregate
class Assignment(

    val id: Long,

    val content: String,

    val dateTimetableId: Long,

    val teacherId: Long

)