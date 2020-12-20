package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.controller.request.ProductRequest
import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.ProductServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("starbucks")
class ProductController(private val serviceImpl: ProductServiceImpl,
                        private val productResponse: ProductResponse,
                        private val product: Product) {

    @PostMapping("/api/v1/product")
    fun createProduct(@RequestBody productRequest: ProductRequest): ResponseEntity<ProductResponse> {
        serviceImpl.persistProduct(product)
        return ResponseEntity.ok(productResponse)
    }

    @GetMapping("/get/product/{name}")
    fun getProduct(@PathVariable id: String): ResponseEntity<ProductResponse?> {
        serviceImpl.getById(id)
        return ResponseEntity.ok(productResponse)
    }

    @DeleteMapping("/delete/product/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Unit> {
        serviceImpl.deleteById(id, product)
        return ResponseEntity.ok(Unit)
    }

    @PutMapping("/update/product/{id}")
    fun updateProduct(@RequestBody productRequest: ProductRequest,
                      @PathVariable id: String): ResponseEntity<Unit> {
        serviceImpl.updateProduct(id, product)
        return ResponseEntity.ok(Unit)
    }

}