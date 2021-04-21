package br.com.jhonatansouza.starbuckets.model.response

data class ProviderResponse(
    var id: String,
    var name: String,
    var address: AddressResponse
)