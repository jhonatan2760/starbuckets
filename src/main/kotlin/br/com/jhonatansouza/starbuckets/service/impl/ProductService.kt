package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product

interface ProductService {

    fun persistProduct(product: Product)

    fun getById(id: Long): Product?

    fun deleteById(id: Long, product: Product)

    fun updateProduct(id: Long, product: Product)

}