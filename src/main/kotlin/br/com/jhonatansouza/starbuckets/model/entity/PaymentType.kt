package br.com.jhonatansouza.starbuckets.model.entity

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class PaymentType(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val holderName: String,
    val cardName: String,
    val cardNumber: String,
    val cvv: String,
    val cardType: Enum<PaymentEnum>,
    val issuer: Enum<IssuerEnum>,
    val isPrincipal: Boolean,
    val active: Boolean
)