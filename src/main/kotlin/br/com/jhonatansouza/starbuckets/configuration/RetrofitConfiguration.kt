package br.com.jhonatansouza.starbuckets.configuration

import br.com.jhonatansouza.starbuckets.service.clients.VaultClient
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Component
class RetrofitConfiguration {

    @Bean
    fun vaultClient(): VaultClient {
        return this.retrofitBuilder("api/v1/vault/").create()
    }

    private fun retrofitBuilder(path: String): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        return Retrofit.Builder()
            .baseUrl("http://localhost:8082/$path")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}