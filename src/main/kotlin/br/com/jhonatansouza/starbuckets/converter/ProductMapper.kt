package br.com.jhonatansouza.starbuckets.converter

import br.com.jhonatansouza.starbuckets.model.dto.ProductDTO
import br.com.jhonatansouza.starbuckets.model.entity.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper : Mapper<ProductDTO, Product>() {

    override fun toEntity(dto: ProductDTO): Product {
        return Product(
            name = dto.name,
            description = dto.description,
            price = dto.price,
            status = dto.status
        )
    }

}