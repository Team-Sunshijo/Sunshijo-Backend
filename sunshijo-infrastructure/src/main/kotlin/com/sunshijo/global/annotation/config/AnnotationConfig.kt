package com.sunshijo.global.annotation.config

import com.sunshijo.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan (
        basePackages = ["com.sunshijo"],
        includeFilters = [
            Filter (
                    type = FilterType.ANNOTATION,
                    classes = [
                        UseCase::class,
                    ]
            )
        ]
)
class AnnotationConfig {
}