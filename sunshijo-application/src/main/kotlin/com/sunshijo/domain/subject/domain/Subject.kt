package com.sunshijo.domain.subject.domain

import com.sunshijo.annotation.Aggregate
import java.util.UUID

@Aggregate
class Subject (

        val id: UUID,

        val name: String
)