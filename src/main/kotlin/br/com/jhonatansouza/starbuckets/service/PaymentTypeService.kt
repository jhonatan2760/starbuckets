package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.converter.PaymentMapper
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.exception.PaymentTypeException
import br.com.jhonatansouza.starbuckets.model.dto.PaymentTypeDTO
import br.com.jhonatansouza.starbuckets.model.entity.PaymentType
import br.com.jhonatansouza.starbuckets.model.entity.User
import br.com.jhonatansouza.starbuckets.model.request.CreditCardRequest
import br.com.jhonatansouza.starbuckets.repository.PaymentTypeRepository
import br.com.jhonatansouza.starbuckets.service.clients.VaultClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PaymentTypeService(
    private val repository: PaymentTypeRepository,
    private val vaultClient: VaultClient,
    private val converter: PaymentMapper,
    private val user: UserService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(payment: PaymentTypeDTO, cardNumber: String, expirationDate: String): PaymentType {
        logger.info("Save payment Type to database")
        val vault = vaultClient.createCardToken(
            CreditCardRequest(
                payment.cardNumber,
                cvv = payment.cvv,
                holderName = payment.holderName,
                expireDate = expirationDate,
                brand = payment.issuer.name
            )
        ).execute().code() == 415
        if (vault) {
            return repository.save(converter.toEntity(payment)) as PaymentType
        }
        this.logger.error("PaymentTypeService -> Unable to register creditcard.")
        throw PaymentTypeException("Não foi possível registrar o meio de pagamento!")

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

    fun update(id: Long, payment: PaymentTypeDTO) {
        logger.info("update payment type by id")
        if (this.getById(id) != null) {
            repository.save(converter.toEntity(payment))

        } else {
            throw GenericException("User not find with id $id")
        }
    }

}