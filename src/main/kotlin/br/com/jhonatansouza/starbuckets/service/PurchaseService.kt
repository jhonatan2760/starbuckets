package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.exception.PurchaseException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val productService: ProductService,
    private val userService: UserService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun createPurchase(userId: Long, productId: Long, paymentType: PaymentEnum){
        this.logger.info("action= creation transaction productId=$productId, userId=$userId")
        val user = this.userService.getByid(userId)
        val product = this.productService.getById(productId)
        if (user.active && product.price > 0.0){
         this.logger.info("action= active user product with correct value")
        } else {
           throw PurchaseException("unauthorized purchase invalid")
        }
    }

}