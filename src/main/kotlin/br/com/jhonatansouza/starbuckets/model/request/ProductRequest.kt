package br.com.jhonatansouza.starbuckets.model.request

import br.com.jhonatansouza.starbuckets.model.dto.ProductDTO

data class ProductRequest(
    val name: String,
    val description: String,
    val price: Double,
    var status: String?
) {

    companion object {

        fun toProduct(request: ProductRequest) = ProductDTO(
            name = request.name,
            description = request.description,
            price = request.price,
            status = request.status
        )
    }
}
