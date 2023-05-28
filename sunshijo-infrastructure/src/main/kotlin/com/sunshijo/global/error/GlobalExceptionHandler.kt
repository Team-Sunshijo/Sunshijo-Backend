package com.sunshijo.global.error

import com.sunshijo.error.SunshijoException
import com.sunshijo.global.error.response.BaseErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<*> {
        val errorMap = mutableMapOf<String, String?>()

        for (error: FieldError in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(e: ConstraintViolationException): ResponseEntity<*> {
        val errorMap = mutableMapOf<String, Any?>()
        val errors = mutableListOf<String>()

        for (violation in e.constraintViolations) {
            errors.add(violation.rootBeanClass.name + " " + violation.propertyPath + " " + violation.message)
        }
        errorMap["errors"] = errors
        errorMap["message"] = e.message

        return ResponseEntity(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(SunshijoException::class)
    fun handleCustomException(e: SunshijoException): ResponseEntity<BaseErrorResponse> {

        return ResponseEntity(
            BaseErrorResponse.of(e),
            HttpStatus.valueOf(e.status)
        )
    }
}