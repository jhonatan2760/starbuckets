package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.PaymentType
import br.com.jhonatansouza.starbuckets.model.request.PaymentTypeRequest
import br.com.jhonatansouza.starbuckets.model.response.PaymentTypeResponse
import br.com.jhonatansouza.starbuckets.service.PaymentTypeService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/v1/payment-method")
class PaymentTypeController(private val service: PaymentTypeService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody paymentTypeRequest: PaymentTypeRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("creating payment type name${paymentTypeRequest.holderName}")
        return ResponseEntity.created(
            uri.path("/api/payment/type/v1/{id}").build(
                service.create(
                    PaymentTypeRequest.toPaymenType(paymentTypeRequest),
                    paymentTypeRequest.cardNumber,
                    paymentTypeRequest.expirationDate
                ).id
            )
        ).build()
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long
    ): ResponseEntity<PaymentTypeResponse> {
        logger.info("looking for payment type by id, user=$id")
        return ResponseEntity.ok(
            PaymentTypeResponse.toPaymentResponse(
                service.getById(id)
            )
        )
    }

    @PutMapping("/{id}")
    fun UpadateUser(
        @PathVariable id: Long,
        @RequestBody paymentType: PaymentType
    ): ResponseEntity<Unit> {
        logger.info("looking for payment type by id and updating, user=$id")
        return ResponseEntity.ok(service.update(id, paymentType))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Long
    ): ResponseEntity<Unit> {
        logger.info("deleting payment type by id, user=$id")
        return ResponseEntity.ok(service.delete(id))
    }
}