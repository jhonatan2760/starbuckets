package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(val repository: ProductRepository) {

    fun create(product: Product): Product {
        valida(product)
        return this.repository.save(product)
    }

    fun delete(id: Long) {
        if (this.getById(id) != null) {
        } else {
            throw GenericException("Product not found with id $id")
        }
    }

    fun getAll(page: Pageable): Page<Product> =
        this.repository.findAll(page)

    fun getById(id: Long): Product =
        this.repository.findById(id).get()

    fun update(id: Long, product: Product) {
        if (getById(id) != null) {
            delete(id)
            create(product)
        } else {
            throw GenericException("Product not found")
        }
    }

    fun valida(product: Product) {
        if (product.name.isEmpty())
            throw GenericException(message = "value cannot be empty")

        if (product.price < 1)
            throw GenericException(message = "price cannot be less than 1 real")
    }
}