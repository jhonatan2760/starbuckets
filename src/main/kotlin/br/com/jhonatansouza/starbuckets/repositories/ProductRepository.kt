package br.com.jhonatansouza.starbuckets.repositories

import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ProductRepository : MongoRepository<Product, String> {

    override fun findById(id: String): Optional<Product>




}