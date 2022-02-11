package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.entity.PaymentType

data class PaymentTypeResponse(
    val id: Long?,
    val holderName: String,
    val cardName: String,
    val cardType: Enum<PaymentEnum>,
    val issuer: Enum<IssuerEnum>,
    val isPrincipal: Boolean,
    val active: Boolean
) {
    companion object {
        fun toPaymentResponse(entity: PaymentType) = PaymentTypeResponse(
            id = entity.id,
            holderName = entity.holderName,
            cardName = entity.cardName,
            cardType = entity.cardType,
            issuer = entity.issuer,
            isPrincipal = entity.isPrincipal,
            active = entity.active
        )
    }
}