package com.sunshijo.error

open class SunshijoException(val errorProperty: ErrorProperty) : RuntimeException() {

    val status: Int
        get() = errorProperty.status

    override val message: String
        get() = errorProperty.message
}