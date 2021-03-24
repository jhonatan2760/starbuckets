package br.com.jhonatansouza.starbuckets.model.response

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductResponse(val id: String,
                           val name: String,
                           val description: String,
                           val price: Double) {

    companion object {
        fun fromEntity(entity: Product) = ProductResponse(
                entity.id,
                entity.name,
                entity.description,
                entity.price
        )
    }

}

