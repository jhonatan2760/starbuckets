package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.dto.UserDTO
import br.com.jhonatansouza.starbuckets.model.entity.User
import org.springframework.stereotype.Component

@Component
class UserMapper : Mapper<UserDTO, User>(){

    override fun toEntity(dto: UserDTO): User {
        return User(
            name = dto.name,
            email = dto.email,
            password = dto.password,
            birthDate = dto.birthDate,
            type = dto.type,
            active = dto.active
        )
    }
}