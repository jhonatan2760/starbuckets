package br.com.jhonatansouza.starbuckets.exception

import br.com.jhonatansouza.starbuckets.model.response.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler
    fun handlerException(ex: Exception, request: WebRequest): ErrorResponse{

       return ErrorResponse(
            400,
            "este recurso não existe",
            "0001",
            null
        )
    }
}