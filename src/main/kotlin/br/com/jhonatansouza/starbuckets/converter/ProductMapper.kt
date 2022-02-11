package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.entity.Product
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import org.springframework.stereotype.Component

@Component
class ProductMapper : Mapper<ProductRequest, Product>() {

    override fun toEntity(dto: ProductRequest): Product {
        return Product(
            name = dto.name,
            description = dto.description,
            price = dto.price
        )
    }

}