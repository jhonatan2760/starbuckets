package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.Purchase
import br.com.jhonatansouza.starbuckets.model.request.PostPurchaseRequest
import br.com.jhonatansouza.starbuckets.service.ProductService
import br.com.jhonatansouza.starbuckets.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val productService: ProductService,
    private val userService: UserService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun toEntity(purchaseRequest: PostPurchaseRequest): Purchase{
        val user = userService.getByid(purchaseRequest.userId)
        val product = productService.findAllById(purchaseRequest.productId)

        return Purchase(
            user = user,
            product = product,
            price = product.sumOf { it.price }
        )
    }
}