package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.exception.PurchaseException
import br.com.jhonatansouza.starbuckets.model.Purchase
import br.com.jhonatansouza.starbuckets.repository.PurchaseRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(purchase: Purchase) {
        purchaseRepository.save(purchase)
    }

    fun findAll():List<Purchase>{
       return purchaseRepository.findAll()
    }

}