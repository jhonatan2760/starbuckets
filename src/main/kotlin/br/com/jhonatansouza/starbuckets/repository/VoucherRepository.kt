package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.Voucher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoucherRepository : JpaRepository<Voucher, Long>