package br.com.jhonatansouza.starbuckets.model.request

import com.google.gson.annotations.SerializedName

data class CreditCardRequest(
    @SerializedName("cardNumber")
    val cardNumber: String,
    @SerializedName("cvv")
    val cvv: String,
    @SerializedName("holderName")
    val holderName: String,
    @SerializedName("expireDate")
    val expireDate: String,
    @SerializedName("brand")
    val brand: String
)
