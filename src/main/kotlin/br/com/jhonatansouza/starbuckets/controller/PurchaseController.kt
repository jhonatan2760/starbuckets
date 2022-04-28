package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.converter.PurchaseMapper
import br.com.jhonatansouza.starbuckets.model.Purchase
import br.com.jhonatansouza.starbuckets.model.request.PostPurchaseRequest
import br.com.jhonatansouza.starbuckets.service.PurchaseService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/purchase")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest){
        purchaseService.create(purchaseMapper.toEntity(request))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findAll(): ResponseEntity<List<Purchase>>{
       return ResponseEntity.ok(purchaseService.findAll().toList())
    }
}