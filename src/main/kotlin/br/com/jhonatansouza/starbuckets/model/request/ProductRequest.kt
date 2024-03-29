package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductRequest(
    val name: String,
    val description: String,
    val price: Double
) {

    companion object {

        fun toProduct(request: ProductRequest) = Product(
            name = request.name,
            description = request.description,
            price = request.price
        )
    }
}
