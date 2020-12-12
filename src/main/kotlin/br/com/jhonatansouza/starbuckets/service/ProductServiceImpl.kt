package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repositories.ProductRepository
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.stereotype.Service

@Service


class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun persist(product: Product): Product = productRepository.save(product)

    override fun findByName(name: String): Product? = productRepository.findByName(name)




}