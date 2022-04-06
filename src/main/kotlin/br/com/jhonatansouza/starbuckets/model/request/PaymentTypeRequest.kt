package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.dto.PaymentTypeDTO

data class PaymentTypeRequest(
    val holderName: String,
    val cardName: String,
    val cardNumber: String,
    val cardType: PaymentEnum,
    val cvv: String,
    val issuer: IssuerEnum,
    val isPrincipal: Boolean,
    val active: Boolean,
    val expirationDate: String
) {
    companion object{
        fun toPaymentType(request: PaymentTypeRequest) = PaymentTypeDTO(
            holderName = request.holderName,
            cardNumber = request.cardNumber,
            cardName = request.cardName,
            cvv = request.cvv,
            cardType = request.cardType,
            issuer = request.issuer,
            isPrincipal = request.isPrincipal,
            active = request.active
        )
    }
}