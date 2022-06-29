package br.com.jhonatansouza.starbuckets.model.entity

import javax.persistence.*

@Entity(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = 0,
    @Column(length = 255)
    var name: String,
    @Column(length = 2000)
    val description: String,
    val price: Double,
    val status: String?
)
