package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.ProductException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import br.com.jhonatansouza.starbuckets.service.impl.ProductServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductServiceTest {

    var service: ProductService = ProductServiceImpl()

    @Test
    fun `when register a product, the price shouldnt be less than 0_99`() {
        assertThrows<ProductException> {
            service.create(createProduct(price = 0.00))
        }
    }

    @Test
    fun `when register a product and the price is more than 1 Real, should verify the product name`(){
        val response = service.create(createProduct(name = "Café Expresso", price = 14.0))
        assert(response.name == "Café Expresso")
    }


    private fun createProduct(name: String = "Product Name", price: Double): Product {
        return Product(
                3120L,
                name,
                "Description",
                price)
    }
}