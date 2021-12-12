package br.com.jhonatansouza.starbuckets.configuration

import br.com.jhonatansouza.starbuckets.service.clients.VaultClient
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component
class RetrofitConfiguration {

    @Bean
    fun vaultClient(): VaultClient {
        return this.retrofitBuilder("api/").create(VaultClient::class.java)
    }

    private fun retrofitBuilder(path: String): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .create()

        return Retrofit.Builder()
            .baseUrl("http://localhost:8082/$path")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}