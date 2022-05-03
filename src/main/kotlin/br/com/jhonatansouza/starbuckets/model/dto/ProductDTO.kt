package br.com.jhonatansouza.starbuckets.model.dto

import javax.persistence.Column


data class ProductDTO(
    @Column(unique = true)
    var name: String,
    val description: String,
    val price: Double
)