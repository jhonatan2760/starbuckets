package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.model.response.ProductResponse
import br.com.jhonatansouza.starbuckets.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/supplier/v1")
class ProductWithSupplierController(private var service: ProductService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun createProductWithSupplier(
            @RequestBody request: ProductRequest,
            uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("Creating product, productName=${request.name}")
        return ResponseEntity.created(uri.path("/api/product/v1/{id}")
                .build(service.create(ProductRequest.toEntity(request)).id)).build()
    }

    @PostMapping("/generate")
    fun createData(): ResponseEntity<String> {
        this.logger.info("create itens pag")
        val response = service.createData()
        return ResponseEntity.ok(response.toString())
    }

    @GetMapping
    fun getAllProduct(page: Pageable): ResponseEntity<Page<Product>> {
        this.logger.info("Get all product")
        return ResponseEntity.ok(service.getAll(page))
    }

    @GetMapping("/{id}")
    fun findProductWithSupplier(@PathVariable id: String): ResponseEntity<ProductResponse> {
        logger.info("Finding product, productId=$id")
        return ResponseEntity.ok(ProductResponse.fromEntity(service.getById(id)))
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody product: Product): ResponseEntity<Unit> {
        this.logger.info("")
        return ResponseEntity.ok(service.update(id, product))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Unit> {
        this.logger.info("Deleting product with id=$id")
        return ResponseEntity.ok(service.delete(id))
    }
}