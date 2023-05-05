package com.sunshijo.global.entity

interface GenericMapper<D, E> {

    fun toDomain(entity: E): D
    fun toEntity(domain: D): E
}