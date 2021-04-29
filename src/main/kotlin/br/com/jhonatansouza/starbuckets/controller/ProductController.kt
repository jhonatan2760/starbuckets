package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.model.response.ProductResponse
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream

@RestController
@RequestMapping("api/product/v1")
class ProductController(private var service: ProductService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{id}")
    fun findProduct(@PathVariable id: String): ResponseEntity<ProductResponse> {
        logger.info("Finding product, productId=$id")
        return ResponseEntity.ok(ProductResponse.fromEntity(service.getById(id)))
    }

    @PostMapping
    fun create(
            @RequestBody request: ProductRequest,
            uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("Creating product, productName=${request.name}")
        return ResponseEntity.created(uri.path("/api/product/v1/{id}")
                .build(service.create(ProductRequest.toEntity(request)).id)).build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        this.logger.info("Deleting product with id=$id")
        return ResponseEntity.ok(service.delete(id))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Product>> {
        this.logger.info("Get all product")
        return ResponseEntity.ok(service.getAll())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody product: Product): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.update(id, product))
    }

    @PostMapping("/generate")
    fun createData(): ResponseEntity<String> {
        this.logger.info("create itens pag")
        val response = service.createData()
        return ResponseEntity.ok(response.toString())
    }
}