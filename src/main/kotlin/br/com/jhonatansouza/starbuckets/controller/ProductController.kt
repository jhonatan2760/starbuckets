package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.ProductStatus
import br.com.jhonatansouza.starbuckets.model.entity.Product
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.model.response.ProductResponse
import br.com.jhonatansouza.starbuckets.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/product/v1")
class ProductController(
    private val productService: ProductService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody request: ProductRequest, uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        request.status = ProductStatus.ATIVO.toString()
        logger.info("Creating product, productName=${request.name}")
        return ResponseEntity.created(
            uri.path("/api/product/v1/{id}").build(productService.create(ProductRequest.toProduct(request)).id)
        ).build()
    }

    @GetMapping("/{id}")
    fun findProduct(@PathVariable id: Long): ResponseEntity<ProductResponse> {
        logger.info("Finding product, productId=$id")
        return ResponseEntity.ok(ProductResponse.toResponse(productService.getById(id)))
    }

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long, @RequestBody product: ProductRequest
    ): ResponseEntity<Unit> {
        this.logger.info("")
        return ResponseEntity.ok(productService.update(id, ProductRequest.toProduct(product)))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Unit> {
        this.logger.info("Deleting product with id=$id")
        return ResponseEntity.ok(productService.delete(id))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): ResponseEntity<Page<Product>> {
        return ResponseEntity.ok(productService.findAll(pageable))
    }
}