package br.com.jhonatansouza.starbuckets.model

import java.math.BigDecimal

data class Product(
        val id: Long,
        var name: String,
        val description: String,
        val price: Double
)
