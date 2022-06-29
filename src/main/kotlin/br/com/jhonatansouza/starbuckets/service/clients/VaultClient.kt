package br.com.jhonatansouza.starbuckets.service.clients

import br.com.jhonatansouza.starbuckets.model.request.CreditCardRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface VaultClient {

    @POST("v1/vault/")
    fun createCardToken(@Body creditCardRequest: CreditCardRequest): Response<Void>
}