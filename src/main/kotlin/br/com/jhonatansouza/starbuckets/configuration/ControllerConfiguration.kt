package br.com.jhonatansouza.starbuckets.configuration

import br.com.jhonatansouza.starbuckets.exception.PaymentTypeException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerConfiguration {

    @ExceptionHandler(PaymentTypeException::class)
    fun unableToRegisterCardType(ex: PaymentTypeException): ResponseEntity<String> {
        return ResponseEntity.status(500).body<String>(ex.message ?: "Unable to handle card.")
    }

}