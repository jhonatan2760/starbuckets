package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.model.Address
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.Provider
import java.util.*

data class ProductRequest(
    val name: String,
    val description: String,
    val price: Double,
    val provider: ProviderRequest
) {

    companion object {

        fun toEntity(request: ProductRequest) = Product(
            name = request.name,
            description = request.description,
            price = request.price,
            provider = Provider(
                id = UUID.randomUUID().toString(),
                request.provider.name,
                Address(
                    request.provider.address.street,
                    request.provider.address.zipCode,
                    request.provider.address.city,
                    request.provider.address.state,
                    request.provider.address.complement,

                )
            )
        )
    }
}
