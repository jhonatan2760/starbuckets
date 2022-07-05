package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.request.PaymentTypeRequest
import br.com.jhonatansouza.starbuckets.model.response.PaymentTypeResponse
import br.com.jhonatansouza.starbuckets.service.PaymentTypeService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController

class PaymentTypeController(private val service: PaymentTypeService) {

   
}