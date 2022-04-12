package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.service.PurchaseService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
        @PathVariable paymentType: PaymentEnum,
    ) {
        logger.info("action=validating customer transaction")
        ResponseEntity.ok(purchaseService.createPurchase(userId,productId,paymentType))
    }
}