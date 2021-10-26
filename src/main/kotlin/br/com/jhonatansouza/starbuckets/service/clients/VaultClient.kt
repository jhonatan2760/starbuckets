package br.com.jhonatansouza.starbuckets.service.clients

import br.com.jhonatansouza.starbuckets.model.HelloResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HelloClient {

    @GET("hello/{username}")
    fun getUser(@Path("username") userName: String) : Call<HelloResponse>

}