package br.com.jhonatansouza.starbuckets.model.dto

import java.time.LocalDateTime

data class VoucherDTO(
    val id: Long? = 0,
    val name: String,
    val userId: Long,
    val value: Double,
    val createdAt: LocalDateTime,
    val expiresAt: LocalDateTime,
    val active: Boolean
)