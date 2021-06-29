package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductResponse(
    val id: Long?,
    val name: String,
    val description: String,
    val price: Double
) {

    companion object {
        fun toResponse(entity: Product) = ProductResponse(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            price = entity.price
        )
    }

}

