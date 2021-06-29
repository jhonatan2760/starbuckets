package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.PaymentType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentTypeRepository : JpaRepository<PaymentType, Long>