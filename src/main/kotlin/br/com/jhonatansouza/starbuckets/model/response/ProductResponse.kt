package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductResponse(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val provider: ProviderResponse
) {

    companion object {
        fun fromEntity(entity: Product) = ProductResponse(
            entity.id,
            entity.name,
            entity.description,
            entity.price,
            provider = ProviderResponse(
                entity.provider.id,
                entity.provider.name,
                AddressResponse(
                    entity.provider.address.street,
                    entity.provider.address.zipCode,
                    entity.provider.address.city,
                    entity.provider.address.state,
                    entity.provider.address.complement
                )
            )


        )
    }

}

