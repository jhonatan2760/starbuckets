package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Voucher
import br.com.jhonatansouza.starbuckets.repository.VoucherRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class VoucherService(private val repository: VoucherRepository) {

    val logger = LoggerFactory.getLogger(javaClass)

    fun create(voucher: Voucher): Voucher {
        return repository.save(voucher)
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

    fun update(id: Long, voucher: Voucher) {
        if (this.repository.findById(id) != null) {
            delete(id)
            create(voucher)
        } else {
            throw GenericException("voucher not find with id $id")
        }
    }
}