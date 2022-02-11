package br.com.jhonatansouza.starbuckets.model.dto

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum

data class PaymentTypeDTO(
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