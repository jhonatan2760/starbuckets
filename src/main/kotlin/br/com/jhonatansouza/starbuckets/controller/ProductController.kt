package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/product/v1")
class ProductController(private var service: ProductService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{id}")
    fun findProduct(@PathVariable id: String): ResponseEntity<Product> {
        logger.info("Finding product, productId=$id")
        return ResponseEntity.ok(service.getById(id))
    }

    @PostMapping
    fun create(
            @RequestBody product: ProductRequest,
            uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("Creating product, productName=${product.name}")
        return ResponseEntity.created(uri.path("/api/product/v1/{id}")
                .build(service.create(
                        Product(id = "", name = product.name,
                        price = product.price,
                        description = product.description
                )).id)).build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        this.logger.info("Deleting product with id=$id")
        return ResponseEntity.ok(service.delete(id))
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody product: Product): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.update(id, product))
    }


}