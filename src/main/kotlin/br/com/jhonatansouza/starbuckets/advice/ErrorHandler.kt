package br.com.jhonatansouza.starbuckets.advice

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(GenericException::class)
    fun productNotFundExceptionHandler(
            serveletRequest: HttpServletRequest, serveletResponse: HttpServletResponse, exception: GenericException):
            ResponseEntity<ErrorMessage> {

        return ResponseEntity(ErrorMessage("Oops...", exception.message.orEmpty()), HttpStatus.NOT_FOUND)
    }
}