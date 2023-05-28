package com.sunshijo.global.entity

import javax.persistence.*

@MappedSuperclass
abstract class BaseIDEntity(
    id: Long
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = id
}