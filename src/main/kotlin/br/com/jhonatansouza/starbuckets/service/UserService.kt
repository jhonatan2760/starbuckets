package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.User
import br.com.jhonatansouza.starbuckets.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(user: User): User {
        logger.info("validate function so name cannot be written empty")
        validateFunction(user)
        logger.info("Save user to database")
        return this.repository.save(user)
    }

    fun getByid(id: Long): User {
        logger.info("looking for user in database")
        return this.repository.findById(id).get()

    }

    fun delete(id: Long) {
        if (this.getByid(id) != null) {
            repository.deleteById(id)
        } else {
            throw GenericException("User not find with id $id")

        }
    }

fun upadate(id: Long, user: User) {
        if (getByid(id) != null) {
            delete(id)
            create(user)
        } else {
            throw GenericException("User not find with id $id")
        }
    }

    fun validateFunction(user: User){
        if (user.name.isEmpty())
            throw GenericException(message = "value cannot be empty")
    }




}