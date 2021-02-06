package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product

interface ProductService {

    fun create(product: Product)

    fun delete(id: Long)

    fun getById(id: Long): Product?

    fun update(id: Long, product: Product)

    fun serchByName(name: String): List<Product>

}