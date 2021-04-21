package br.com.jhonatansouza.starbuckets.model.request

data class AddressRequest(
    var street: String,
    var zipCode: String,
    var city: String,
    var state: String,
    var complement: String
)