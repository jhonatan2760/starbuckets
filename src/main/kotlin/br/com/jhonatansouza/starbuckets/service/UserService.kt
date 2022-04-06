package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.converter.UserMapper
import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.exception.UserException
import br.com.jhonatansouza.starbuckets.exception.UserNotFoundException
import br.com.jhonatansouza.starbuckets.model.dto.UserDTO
import br.com.jhonatansouza.starbuckets.model.entity.User
import br.com.jhonatansouza.starbuckets.repository.UserRepository
import br.com.jhonatansouza.starbuckets.utils.SecurityComponent
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository,
    private val securityComponent: SecurityComponent,
    private val converter: UserMapper
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(user: UserDTO): UserDTO {
        logger.info("validate function so name cannot be written empty")
        validateFunction(user)
        logger.info("Save user to database")
        try {
            return this.repository.save(converter.toEntity(user)) as UserDTO
        } catch (ex: DataIntegrityViolationException) {
            logger.info("User already has an account, ${user.email}")
            throw UserException("Você já possuí uma conta, esqueceu sua senha?")
        }
    }

    fun getByid(id: Long): User {
        logger.info("looking for user in database")
        val userReceiver = this.repository.findById(id)
        if (userReceiver.isPresent) {
            return userReceiver.get()
        } else {
            throw UserNotFoundException("Usuário não encontrado no sistema.")
        }

    }

    fun delete(id: Long) {
        if (this.getByid(id) != null) {
            repository.deleteById(id)
        } else {
            throw GenericException("User not find with id $id")

        }
    }

    fun upadate(id: Long, user: UserDTO) {
        if (getByid(id) != null) {
            delete(id)
            create(user)
        } else {
            throw GenericException("User not find with id $id")
        }
    }

    fun validateFunction(user: UserDTO) {
        if (user.name.isEmpty())
            throw GenericException(message = "value cannot be empty")
        val hashPassword = this.securityComponent.stringToMd5(user.password)
        if (!hashPassword.isNullOrBlank())
            user.password = hashPassword
    }

}