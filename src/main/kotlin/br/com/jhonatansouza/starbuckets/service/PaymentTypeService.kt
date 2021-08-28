package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.PaymentType
import br.com.jhonatansouza.starbuckets.repository.PaymentTypeRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PaymentTypeService(private val repository: PaymentTypeRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(payment: PaymentType): PaymentType {
        logger.info("Save payment Type to database")
        return repository.save(payment)
    }

    fun getById(id: Long): PaymentType {
        logger.info("looking for payment type in database")
        return repository.findById(id).get()
    }

    fun delete(id: Long) {
        logger.info("deleting payment type by id")
        if (this.getById(id) != null) {
            repository.deleteById(id)
        } else {
            throw GenericException("User not find with id $id")
        }
    }

    fun update(id: Long, payment: PaymentType) {
        logger.info("update payment type by id")
        if (this.getById(id) != null) {
            delete(id)
            create(payment)
        } else {
            throw GenericException("User not find with id $id")
        }
    }

}