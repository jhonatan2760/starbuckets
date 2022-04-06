package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.enum.UserEnum
import br.com.jhonatansouza.starbuckets.model.dto.UserDTO
import br.com.jhonatansouza.starbuckets.model.entity.User

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String,
    val type: UserEnum,
    val active: Boolean
) {
    companion object {

        fun toUser(request: UserRequest) = UserDTO(
            name = request.name,
            email = request.email,
            password = request.password,
            birthDate = request.birthDate,
            type = request.type,
            active = request.active
        )
    }
}