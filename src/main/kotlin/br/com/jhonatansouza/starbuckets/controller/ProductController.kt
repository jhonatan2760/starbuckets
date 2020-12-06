package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.config.AgeToggle
import br.com.jhonatansouza.starbuckets.controller.request.ProductRequest
import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import br.com.jhonatansouza.starbuckets.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val service: ProductService, private val toggle: AgeToggle) {

    @PostMapping("/api/v1/product")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse>{

        //service.createProduct(request.toModel())
        return ResponseEntity.ok(ProductResponse("${request.name} - foi recebido - ${toggle.age}"))
    }

}