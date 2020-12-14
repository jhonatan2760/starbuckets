package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.controller.request.ProductRequest
import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.ProductServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(private val serviceImpl: ProductServiceImpl,
                        private val product: Product,
                        private val productResponse: ProductResponse) {

    @PostMapping("/api/v1/product")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        this.serviceImpl.persistProduct(product)
        return ResponseEntity.ok(productResponse)
    }

    @GetMapping("/get/product/{name}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductResponse> {
        this.serviceImpl.findById(id)
        return ResponseEntity.ok(productResponse)
    }

    @DeleteMapping("/delete/product/{name}")
    fun deleteProduct(@RequestBody request: ProductRequest,
                      @PathVariable id: Long): ResponseEntity<Unit> {
        this.serviceImpl.deleteById(id)
        return ResponseEntity.ok(Unit)
    }

    @PutMapping("/update/product/{id}")
    fun updateProduct(@PathVariable id: Long,
                      @RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        serviceImpl.updateProduct(product)
        return ResponseEntity.ok(productResponse)
    }

}