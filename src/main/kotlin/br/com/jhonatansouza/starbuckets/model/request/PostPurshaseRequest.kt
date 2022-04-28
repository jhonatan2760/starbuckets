package br.com.jhonatansouza.starbuckets.model.request

import com.sun.istack.NotNull

data class PostPurchaseRequest(
    @field:NotNull
    val userId: Long,
    @field:NotNull
    val productId: Set<Long>
)