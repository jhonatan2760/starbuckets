package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product

interface ProductService {

    fun persistProduct(product: Product): Product

    fun findById(id: Long): Product?

    fun updateProduct(product: Product): Product

    fun deleteById(product: Product)
}