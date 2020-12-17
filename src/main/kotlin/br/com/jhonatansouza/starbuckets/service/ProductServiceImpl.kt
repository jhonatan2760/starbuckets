package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repositories.ProductRepository
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.stereotype.Service

@Service


 class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun persistProduct(product: Product) {
        productRepository.save(product)
    }

    override fun getById(id: Long): Product? {
       return productRepository.findById(id)
    }

    override fun deleteById(id: Long, product: Product){
        productRepository.delete(product)
    }

    override fun updateProduct(id: Long, product: Product) {
        deleteById(id, product)
        persistProduct(product)
    }

}


