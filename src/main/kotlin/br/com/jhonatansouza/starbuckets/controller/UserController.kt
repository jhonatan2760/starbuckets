package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.entity.User
import br.com.jhonatansouza.starbuckets.model.request.UserRequest
import br.com.jhonatansouza.starbuckets.model.response.UserResponse
import br.com.jhonatansouza.starbuckets.service.UserService
import br.com.jhonatansouza.starbuckets.service.clients.VaultClient
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val service: UserService, private val client: VaultClient) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody userRequest: UserRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("creating user name${userRequest.name}")
        return ResponseEntity.created(
            uri.path("/api/user/v1/{id}").build(
                service.create(
                    UserRequest.toUser(userRequest)
                ).id
            )
        ).build()
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Long
    ): ResponseEntity<UserResponse> {
        logger.info("looking for user by id, user=$id")
        return ResponseEntity.ok(UserResponse.toResponse(service.getByid(id)))
    }

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody user: User
    ): ResponseEntity<Unit> {
        logger.info("looking for user by id and updating, user=$id")
        return ResponseEntity.ok(service.upadate(id, user))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Long
    ): ResponseEntity<Unit> {
        logger.info("deleting user by id, user=$id")
        return ResponseEntity.ok(service.delete(id))
    }

}