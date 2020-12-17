package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.controller.request.ProductRequest
import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.ProductServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ProductController(private val serviceImpl: ProductServiceImpl,
                        private val productResponse: ProductResponse,
                        private val product: Product) {

    @PostMapping("/api/v1/product")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        serviceImpl.persistProduct(product)
        return ResponseEntity.ok(productResponse)
    }

    @GetMapping("/get/product/{name}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductResponse> {
        serviceImpl.getById(id)
        return ResponseEntity.ok(productResponse)
    }

    @DeleteMapping("/delete/product/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Unit> {
        serviceImpl.deleteById(id, product)
        return ResponseEntity.ok(Unit)
    }

    @PutMapping("/update/product/{id}")
    fun updateProduct(@RequestBody request: ProductRequest,
                      @PathVariable id: Long): ResponseEntity<Unit> {
        serviceImpl.updateProduct(id, product)
        return ResponseEntity.ok(Unit)
    }

}