package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.controller.request.ProductRequest
import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.ProductServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(private val serviceImpl: ProductServiceImpl,
                        private val product: Product,
                        private val productResponse: ProductResponse) {

    @PostMapping("/api/v1/product")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        serviceImpl.persist(product)
        return ResponseEntity.ok(productResponse)
    }

    @GetMapping("/get/product/{name}")
    fun getProduct(@RequestBody request: ProductRequest,
    @PathVariable name: String): ResponseEntity<ProductResponse> {
        serviceImpl.findByName(name = String())
        return ResponseEntity.ok(productResponse)
    }


}