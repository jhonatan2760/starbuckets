package br.com.jhonatansouza.starbuckets.model

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Voucher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val name: String,
    val userId: Long,
    val value: Double,
    val createdAt: LocalDateTime,
    val expiresAt: LocalDateTime,
    val active: Boolean
)