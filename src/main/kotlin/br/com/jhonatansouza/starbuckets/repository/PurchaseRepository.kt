package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.Purchase
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<Purchase, Long> {

}
