package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.model.Product
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

    override fun create(product: Product) {
        products[product.id] = product
    }

    override fun delete(id: Long) {
         products.remove(id)
    }

    override fun getById(id: Long): Product? {
        return products[id]
    }

    override fun update(id: Long, product: Product) {
        delete(id)
        create(product)
    }
}