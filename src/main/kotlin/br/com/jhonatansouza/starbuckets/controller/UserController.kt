package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.entity.User
import br.com.jhonatansouza.starbuckets.model.request.UserRequest
import br.com.jhonatansouza.starbuckets.model.response.UserResponse
import br.com.jhonatansouza.starbuckets.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val service: UserService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun create(
        @RequestBody request: UserRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Any> {
        logger.info("creating user name${request.name}")
        return ResponseEntity.created(
            uri.path("/api/user/v1/{id}").
            build(service.create(UserRequest.toUser(request)).name)
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
        @RequestBody user: UserRequest
    ): ResponseEntity<Unit> {
        logger.info("looking for user by id and updating, user=$id")
        return ResponseEntity.ok(service.upadate(id, UserRequest.toUser(user)))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(
        @PathVariable id: Long
    ): ResponseEntity<Unit> {
        logger.info("deleting user by id, user=$id")
        return ResponseEntity.ok(service.delete(id))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): ResponseEntity<Page<User>> {
        return ResponseEntity.ok(service.findAll(pageable))
    }

}