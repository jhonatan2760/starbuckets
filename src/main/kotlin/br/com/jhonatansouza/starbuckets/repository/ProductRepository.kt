package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: MongoRepository<Product, String>