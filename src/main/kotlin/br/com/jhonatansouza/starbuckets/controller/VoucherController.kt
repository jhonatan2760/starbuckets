package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.entity.Voucher
import br.com.jhonatansouza.starbuckets.model.request.VoucherRequest
import br.com.jhonatansouza.starbuckets.model.response.VoucherResponse
import br.com.jhonatansouza.starbuckets.service.VoucherService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/voucher")
class VoucherController(private val service: VoucherService) {

    val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody voucherRequest: VoucherRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("creating voucher name${voucherRequest.name}")
        return ResponseEntity.created(
            uri.path("/api/voucher/v1/{id}").build(service.create(
                VoucherRequest.toVoucherRequest(voucherRequest)
            ).id)).build()
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long
    ) : ResponseEntity<VoucherResponse> {
        logger.info("looking for user by id, user=$id")
        return ResponseEntity.ok(VoucherResponse.toVoucherResponse(service.findById(id)))
    }

    @PutMapping("/{id}")
    fun UpadateUser(
        @PathVariable id: Long,
        @RequestBody voucher: Voucher
    ): ResponseEntity<Unit> {
        logger.info("looking for user by id and updating, user=$id")
        return ResponseEntity.ok(service.update(id, voucher))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Long
    ): ResponseEntity<Unit> {
        logger.info("deleting user by id, user=$id")
        return ResponseEntity.ok(service.delete(id))
    }
}