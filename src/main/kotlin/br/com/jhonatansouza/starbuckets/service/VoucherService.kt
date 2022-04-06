package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.converter.VoucherMapper
import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.dto.VoucherDTO
import br.com.jhonatansouza.starbuckets.model.entity.Voucher
import br.com.jhonatansouza.starbuckets.repository.VoucherRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class VoucherService(
    private val repository: VoucherRepository,
    private val converter: VoucherMapper
) {

    val logger = LoggerFactory.getLogger(javaClass)

    fun create(voucher: VoucherDTO): VoucherDTO {
        logger.info("Save Voucher Type to database")
        return repository.save(converter.toEntity(voucher)) as VoucherDTO
    }

    fun findById(id: Long): Voucher {
        if (this.repository.findById(id) != null) {
            return this.repository.findById(id).get()
        } else {
            throw GenericException("Voucher not find with id $id")
        }
    }

    fun delete(id: Long) {
        if (this.repository.findById(id) != null) {
            repository.deleteById(id)
        } else {
            throw GenericException("Voucher not find with id $id")
        }
    }

    fun update(id: Long, voucher: VoucherDTO) {
        if (this.repository.findById(id) != null) {
            repository.save(converter.toEntity(voucher))
        } else {
            throw GenericException("voucher not find with id $id")
        }
    }
}