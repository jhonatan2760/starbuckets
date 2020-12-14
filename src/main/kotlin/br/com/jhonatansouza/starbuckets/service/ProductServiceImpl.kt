package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repositories.ProductRepository
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.stereotype.Service

@Service


 class ProductServiceImpl(val productRepository: ProductRepository, val product: Product) : ProductService {

    override fun persistProduct(product: Product): Product = productRepository.save(product)

    override fun findById(id: Long): Product? = productRepository.findById(id)

    override fun deleteById(id: Long): Unit = productRepository.delete(product)

    override fun updateProduct(product: Product): Product = productRepository.update(product)


}


