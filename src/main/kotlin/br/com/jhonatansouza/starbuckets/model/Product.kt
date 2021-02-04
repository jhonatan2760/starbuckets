package br.com.jhonatansouza.starbuckets.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(
        @Id
        val id: Long,
        val name: String,
        val description: String,
        val price: Double
)
