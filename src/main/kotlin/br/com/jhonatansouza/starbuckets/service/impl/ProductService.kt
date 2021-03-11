package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product


interface ProductService {

    fun create(product: Product): Product

    fun delete(id: String)

    fun getById(id: String): Product

    fun update(id: String, product: Product)

}
