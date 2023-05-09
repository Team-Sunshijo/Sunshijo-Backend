package com.sunshijo.global.entity

import javax.persistence.*

@MappedSuperclass
abstract class BaseUUIDEntity (
        id: Long
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = id
}