package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.model.entity.Voucher
import java.time.LocalDateTime

data class VoucherResponse(
    val id: Long?,
    val name: String,
    val userId: Long,
    val value: Double,
    val createdAt: LocalDateTime,
    val expiresAt: LocalDateTime,
    val active: Boolean
) {
    companion object{
        fun toVoucherResponse(entity: Voucher) = VoucherResponse(
            id = entity.id,
            name = entity.name,
            userId = entity.userId,
            value = entity.value,
            createdAt = entity.createdAt,
            expiresAt = entity.expiresAt,
            active = entity.active
        )
    }
}