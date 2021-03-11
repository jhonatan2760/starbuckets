package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.exception.ProductException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class ProductServiceImpl(val repository: ProductRepository): ProductService {


    override fun create(product: Product): Product {
        valida(product)
        //products[product.id] = product
        product.id = UUID.randomUUID().toString()
        return this.repository.save(product)
    }

    override fun delete(id: String) {
        if(this.getById(id) != null){
          //  products.remove(id)
        }else{
            throw ProductException("Product not found with id $id", HttpStatus.NOT_FOUND.value())
        }
    }

    override fun getById(id: String): Product =
        this.repository.findById(id).get()

    override fun update(id: String, product: Product) {
        if(getById(id) != null){
            delete(id)
            create(product)
        }else{
            throw ProductException("Product not found", HttpStatus.NOT_FOUND.value())
        }
    }

    fun valida(product: Product) {
        if (product.name.isEmpty())
            throw ProductException(message = "value cannot be empty", HttpStatus.BAD_REQUEST.value())

        if (product.price < 1)
            throw ProductException(message = "price cannot be less than 1 real", HttpStatus.BAD_REQUEST.value())
    }
}