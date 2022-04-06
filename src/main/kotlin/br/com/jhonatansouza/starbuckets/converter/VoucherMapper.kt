package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.dto.VoucherDTO
import br.com.jhonatansouza.starbuckets.model.entity.Voucher

import org.springframework.stereotype.Component

@Component
class VoucherMapper : Mapper<VoucherDTO, Voucher>() {

    override fun toEntity(dto: VoucherDTO): Voucher {
         return Voucher(
             name = dto.name,
             userId = dto.userId,
             value = dto.value,
             createdAt = dto.createdAt,
             expiresAt = dto.expiresAt,
             active = dto.active
         )
    }
}