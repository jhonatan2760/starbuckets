package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.dto.PaymentTypeDTO
import br.com.jhonatansouza.starbuckets.model.entity.PaymentType
import org.springframework.stereotype.Component

@Component
class PaymentMapper : Mapper<PaymentTypeDTO, PaymentType>() {

    override fun toEntity(dto: PaymentTypeDTO): PaymentType {
        return  return PaymentType(
            holderName = dto.holderName,
            cardName = dto.cardName,
            cardNumber = dto.cardNumber,
            cvv = dto.cvv,
            cardType = dto.cardType,
            issuer = dto.issuer,
            isPrincipal = dto.isPrincipal,
            active = dto.active
        )
    }

}