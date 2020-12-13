package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repositories.ProductRepository
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service


class ProductServiceImpl(val productRepository: ProductRepository, val product: Product) : ProductService {

    override fun persist(product: Product): Product = productRepository.save(product)

    override fun findByName(name: String): Product? = productRepository.findByName(name)

    override fun deleteByName(name: String) = productRepository.deleteAll()


}


