package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product
import java.util.*

interface ProductService {

    fun persistProduct(product: Product)

    fun getById(id: String): Optional<Product>

    fun deleteById(id: String, product: Product)

    fun updateProduct(id: String, product: Product)

}