package com.ythosa.simplespring.app.ws.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.ResponseStatusException

@ControllerAdvice
class AppExceptionsHandler {
    @ExceptionHandler(value = [UserNotFoundException::class])
    fun handleUserNotFoundException(ex: Exception, request: WebRequest): ResponseStatusException {
        return ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
    }
}
