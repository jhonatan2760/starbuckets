package br.com.jhonatansouza.starbuckets.model.response

data class AddressResponse(
    var street: String,
    var zipCode: String,
    var city: String,
    var state: String,
    var complement: String
)