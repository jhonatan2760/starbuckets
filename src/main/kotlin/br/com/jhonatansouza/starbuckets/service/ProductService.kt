package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.converter.ProductMapper
import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.dto.ProductDTO
import br.com.jhonatansouza.starbuckets.model.entity.Product
import br.com.jhonatansouza.starbuckets.model.entity.User
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(
    val repository: ProductRepository,
    val converter: ProductMapper
) {

    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun create(product: ProductDTO): Product {
        this.logger.info("ProductService -> action, starting creating a product. $product")
        valida(product)
        return this.repository.save(converter.toEntity(product))
    }

    fun delete(id: Long) {
        this.logger.info("ProductService -> action, deleting product, productId=$id")
        val product = this.getById(id)
        if (this.getById(id) != null) {
            this.repository.delete(product)
        } else {
            throw GenericException("Product not found with id $id")
        }
    }

    fun getById(id: Long): Product {
        this.logger.info("ProductService -> action, finding by id, $id")
        val product = this.repository.findById(id)
        if (product.isPresent) {
            return product.get()
        } else {
            throw GenericException("Product not found with id $id")
        }
    }

    fun update(id: Long, product: ProductDTO) {
        this.logger.info(
            "ProductService -> action, update product," +
                    " projectId=$id, product=$product"
        )
        if (getById(id) != null) {
            this.repository.save(converter.toEntity(product))
        } else {
            throw GenericException("Product not found")
        }
    }

    fun valida(product: ProductDTO) {
        if (product.name.isEmpty())
            throw GenericException(message = "value cannot be empty")

        if (product.price < 1)
            throw GenericException(message = "price cannot be less than 1 real")
    }

    fun findAllById(productId: Set<Long>): List<Product> {
        return repository.findAllById(productId).toList()
    }

    fun findAll(pageable: Pageable): Page<Product> {
        return repository.findAll(pageable)
    }
}