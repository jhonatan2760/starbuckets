package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product

interface ProductService {

    fun persist(product: Product): Product

    fun findByName(name: String): Product?

    fun deleteByName(name: String)

}