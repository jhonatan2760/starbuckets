package br.com.jhonatansouza.starbuckets.advice

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.exception.UserException
import br.com.jhonatansouza.starbuckets.exception.UserNotFoundException
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

    @ExceptionHandler(UserException::class)
    fun userAlreadyHasAccount(userException: UserException): ResponseEntity<ErrorMessage> {
        val message = userException.message.toString()
        return ResponseEntity(ErrorMessage("Oops...", message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFundExceptionHandler(userNotFoundException: UserNotFoundException):
            ResponseEntity<ErrorMessage> {

        return ResponseEntity(ErrorMessage("Oops...", userNotFoundException.message.orEmpty()), HttpStatus.NOT_FOUND)
    }
}