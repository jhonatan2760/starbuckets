package br.com.jhonatansouza.starbuckets.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Voucher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    val name: String,
    val userId: Long,
    val value: Double,
    @JsonProperty(value = "yyyy-MM-dd")
    val createdAt: LocalDateTime,
    @JsonProperty(value = "yyyy-MM-dd")
    val expiresAt: LocalDateTime,
    val active: Boolean
)