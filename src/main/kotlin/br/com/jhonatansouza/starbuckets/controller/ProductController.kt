package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/product/v1")
class ProductController(private var service: ProductService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{id}")
    fun findProduct(@PathVariable id: Long): ResponseEntity<Product> {
        logger.info("Finding product, productId=$id")
        return ResponseEntity.ok(service.getById(id))
    }

    @PostMapping
    fun create(
            @RequestBody product: Product,
            uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("Creating product, productName=${product.name}")
        return ResponseEntity.created(uri.path("/api/product/v1/{id}").build(service.create(product).id)).build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        this.logger.info("Deleting product with id=$id")
        return ResponseEntity.ok(service.delete(id))
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.update(id, product))
    }


}