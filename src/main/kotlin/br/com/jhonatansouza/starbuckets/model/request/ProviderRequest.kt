package br.com.jhonatansouza.starbuckets.model.request


data class ProviderRequest(
    var name: String,
    var address: AddressRequest
)