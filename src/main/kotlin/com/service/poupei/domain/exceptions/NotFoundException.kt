package com.service.poupei.domain.exceptions

import com.service.poupei.application.controller.exceptionhandler.ErrorType
import org.springframework.http.HttpStatus

class NotFoundException(
    override val message: String,
    override val type: ErrorType = ErrorType.NOT_FOUND
) : DomainException(message, HttpStatus.NOT_FOUND, type)