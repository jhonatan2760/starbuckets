package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repositories.ProductRepository
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.stereotype.Service
import java.util.*
import java.util.Optional as Optional

@Service

 class ProductServiceImpl (val productRepository: ProductRepository) : ProductService {

    override fun persistProduct(product: Product) {
        productRepository.save(product)
    }

    override fun getById(id: String): Optional<Product> {
       return productRepository.findById(id)
    }

    override fun deleteById(id: String, product: Product){
        productRepository.delete(product)
    }

    override fun updateProduct(id: String, product: Product) {
        deleteById(id, product)
        persistProduct(product)
    }

}


