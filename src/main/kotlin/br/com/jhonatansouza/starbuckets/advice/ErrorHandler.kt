package br.com.jhonatansouza.starbuckets.advice

import br.com.jhonatansouza.starbuckets.exception.ProductException
import br.com.jhonatansouza.starbuckets.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(ProductException::class)
    fun productNotFundExceptionHandler(
            serveletRequest: HttpServletRequest, serveletResponse: HttpServletResponse, exception: ProductException):
            ResponseEntity<ErrorMessage> {

        return ResponseEntity(ErrorMessage("Oops...", exception.message.orEmpty()), HttpStatus.NOT_FOUND)
    }
}