package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.model.entity.User

data class UserResponse(
    val id: Long?,
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String,
    val active: Boolean
) {
    companion object {
        fun toResponse(entity: User) = UserResponse(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            password = entity.password,
            birthDate = entity.birthDate,
            active = entity.active
        )
    }
}