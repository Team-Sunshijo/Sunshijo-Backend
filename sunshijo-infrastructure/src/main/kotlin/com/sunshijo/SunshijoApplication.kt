package com.sunshijo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class SunshijoApplication

fun main(args: Array<String>) {
    runApplication<SunshijoApplication>(*args)
}
