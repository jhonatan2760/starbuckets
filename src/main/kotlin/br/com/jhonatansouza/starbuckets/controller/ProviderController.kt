package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.service.impl.ProviderService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import br.com.jhonatansouza.starbuckets.model.Provider


@RestController
@RequestMapping("api/provider/v1")
class ProviderController(
    private val service: ProviderService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody provider: Provider,
        uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("Creating provider ${provider.name}")
        return ResponseEntity.created(
            uri.path("api/v1/provider/{id}").build(
                service.create(provider).id
            )
        ).build()

    }

    @GetMapping("/{name}")
    fun getById(@PathVariable id: String): ResponseEntity<Provider> {
        logger.info("Finding provider, providerId=$id")
        return ResponseEntity.ok(service.getById(id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        logger.info("Delete provider id$id")
        return ResponseEntity.ok(service.delete(id))
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody provider: Provider
    ): ResponseEntity<Unit> {
        logger.info("Update provider id$id")
        return ResponseEntity.ok(service.update(id, provider))
    }


}