package br.com.jhonatansouza.starbuckets.repositories

import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String> {

    fun findByName(name: String):Product
}