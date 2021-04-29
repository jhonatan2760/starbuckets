package br.com.jhonatansouza.starbuckets.model

import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Provider(
    @MongoId
    var id: String ,
    var name: String,
    var address: Address
)

data class Address(
    var street: String,
    var zipCode: String,
    var city: String,
    var state: String,
    var complement: String
    )