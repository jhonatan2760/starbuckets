package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.exception.ProductException
import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ProductServiceImpl: ProductService {

    companion object {
        val initialProductResponse = arrayOf(
                Product(1, "Café", "café tradicional", 2.50),
                Product(2, "Café gelado", "Café tradicional gelado", 2.50),
                Product(3,"chá","chá mate",3.00),
                Product(4,"Café c/ leite","café tradicional com leite quente", 5.00)
        )
    }
    var products =
            ConcurrentHashMap<Long, Product>(initialProductResponse.associateBy(Product::id))

    override fun create(product: Product): Product {
        valida(product)
        products[product.id] = product
        return product
    }

    override fun delete(id: Long) {
        if(this.getById(id) != null){
            products.remove(id)
        }else{
            throw ProductException("Product not found with id $id", HttpStatus.NOT_FOUND.value())
        }
    }

    override fun getById(id: Long) =
            products[id] ?: throw ProductException("product $id not found", HttpStatus.NOT_FOUND.value())


    override fun update(id: Long, product: Product) {
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