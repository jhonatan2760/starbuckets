package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.PaymentType

data class PaymentTypeRequest(
    val holderName: String,
    val cardName: String,
    val cardNumber: String,
    val cardType: PaymentEnum,
    val issuer: IssuerEnum,
    val isPrincipal: Boolean,
    val active: Boolean,
    val expirationDate: String
) {
    companion object{
        fun toPaymenType(request: PaymentTypeRequest) = PaymentType(
            holderName = request.holderName,
            cardName = request.cardName,
            cardType = request.cardType,
            issuer = request.issuer,
            isPrincipal = request.isPrincipal,
            active = request.active
        )
    }
}