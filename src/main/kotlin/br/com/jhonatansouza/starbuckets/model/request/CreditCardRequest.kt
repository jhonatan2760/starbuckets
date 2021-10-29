package br.com.jhonatansouza.starbuckets.model.request

data class CreditCardRequest(
    val cardNumber: String,
    val cvv: String,
    val holderName: String,
    val expireDate: String,
    val brand: String
)
