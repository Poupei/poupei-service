package com.service.poupei.application.controller.exceptionhandler

import com.service.poupei.application.controller.exceptionhandler.ErrorType.UNEXPECTED
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handleInvalidBodyField(ex: HttpMessageNotReadableException): ResponseEntity<ErrorDto> =
        buildResponseEntityFrom(BAD_REQUEST, ErrorType.BAD_REQUEST, ex)

    @ExceptionHandler
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ErrorDto> =
        buildResponseEntityFrom(ex.status, ex.type, ex)

    @ExceptionHandler
    fun handleGenericException(ex: Exception): ResponseEntity<ErrorDto> =
        buildResponseEntityFrom(INTERNAL_SERVER_ERROR, UNEXPECTED, ex)

    private fun buildResponseEntityFrom(status: HttpStatus, type: ErrorType, exception: Exception) =
        ResponseEntity.status(status).body(buildErrorDto(status, type, exception))

    private fun buildErrorDto(status: HttpStatus, type: ErrorType, exception: Exception) =
        ErrorDto(status.value(), type, formatExceptionMessage(exception))

    private fun formatExceptionMessage(ex: Exception) = ex.message ?: ex.localizedMessage ?: "Unhandled exception $ex"
}

data class ErrorDto (
    val status: Int,
    val type: ErrorType,
    val message: String
)

enum class ErrorType {
    NOT_FOUND,
    BAD_REQUEST,
    CLIENT, //TODO : FOR 4XX CLIENT REQ
    EXTERNAL_DEPENDENCY, // TODO: FOR 5XX CLIENT REQ
    UNEXPECTED
}