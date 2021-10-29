package br.com.jhonatansouza.starbuckets.service.clients

import br.com.jhonatansouza.starbuckets.model.request.CreditCardRequest
import br.com.jhonatansouza.starbuckets.model.response.CreditCardResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface VaultClient {

    @POST("/")
    fun createCardToken(@Body creditCardRequest: CreditCardRequest): Call<CreditCardResponse>

}