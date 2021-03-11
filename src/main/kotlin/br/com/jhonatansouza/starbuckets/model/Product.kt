package br.com.jhonatansouza.starbuckets.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document("product")
data class Product(
        @MongoId
        var id: String,
        var name: String,
        val description: String,
        val price: Double
)
