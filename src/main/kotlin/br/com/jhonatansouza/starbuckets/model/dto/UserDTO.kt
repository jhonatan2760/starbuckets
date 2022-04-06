package br.com.jhonatansouza.starbuckets.model.dto

import br.com.jhonatansouza.starbuckets.enum.UserEnum

data class UserDTO(
    val name: String,
    val email: String,
    var password: String,
    val birthDate: String,
    val type: Enum<UserEnum>,
    val active: Boolean
)