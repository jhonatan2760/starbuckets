package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.model.entity.Voucher
import java.time.LocalDateTime

data class VoucherRequest(
    val name: String,
    val userId: Long,
    val value: Double,
    val createdAt: LocalDateTime,
    val expiresAt: LocalDateTime,
    val active: Boolean
) {
    companion object{
        fun toVoucherRequest(request: VoucherRequest) = Voucher(
            name = request.name,
            userId = request.userId,
            value = request.value,
            createdAt = request.createdAt,
            expiresAt = request.expiresAt,
            active = request.active
        )
    }
}