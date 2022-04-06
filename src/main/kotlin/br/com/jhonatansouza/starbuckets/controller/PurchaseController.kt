package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.entity.PaymentType
import br.com.jhonatansouza.starbuckets.service.PurchaseService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/purchase")
class PurchaseController(
    private val purchaseService: PurchaseService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/product/{productId}/user/{userId}/paymentType/{paymentType}")
    fun purchase(
        @PathVariable productId: Long,
        @PathVariable userId: Long,
        @PathVariable paymentType: PaymentEnum
    ){

    }
}