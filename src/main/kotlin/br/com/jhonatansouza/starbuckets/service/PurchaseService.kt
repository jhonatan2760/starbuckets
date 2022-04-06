package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.PurchaseException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val productService: ProductService,
    private val userService: UserService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun createPurchase(userId: Long, productId: Long){
        this.logger.info("action= criando transação productId=$productId, userId=$userId")
        val user = this.userService.getByid(userId)
        val product = this.productService.getById(productId)
        if (user.active && product.price > 0.0){
         this.logger.info("action= usuario ativo produto com valor correto")
        } else {
           throw PurchaseException("não autorizado compra invalida")
        }
    }

}