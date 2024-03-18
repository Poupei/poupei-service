package com.service.poupei.infra.exceptions

import com.service.poupei.application.controller.exceptionhandler.ErrorType
import org.springframework.http.HttpStatus

open class DomainException(
    override val message: String,
    open val status: HttpStatus = HttpStatus.BAD_REQUEST,
    open val type: ErrorType
): RuntimeException(message)
