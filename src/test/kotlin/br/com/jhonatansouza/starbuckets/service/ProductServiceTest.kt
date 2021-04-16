package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert

@SpringBootTest
class ProductServiceTest {

    var service: ProductService = ProductService()

    private val id = 1

    @Test
    fun `when register a product, the price shouldnt be less than 0_99`() {
        assertThrows<GenericException> {
            service.create(createProduct(price = 0.00))
        }
    }

    @Test
    fun `when register a product and the price is more than 1 Real, should verify the product name`() {
        val response = service.create(createProduct(name = "Café Expresso", price = 14.0))
        assert(response.name == "Café Expresso")
    }

    @Test
    fun `quando nome vier vazio, produto não pode ser criado`() {
        assertThrows<GenericException> {
            service.create(createProduct(name = "", price = 1.00))
        }
    }

    private fun createProduct(name: String = "Product Name", price: Double): Product {
        return Product(
            3120L,
            name,
            "Description",
            price
        )
    }

    @Test
    fun `Search product by id`() {
        val product: Product = service.getById(id.toLong())
        Assert.notNull(product)
    }

    @Test
    fun `delete product by id`() {
        val product: Unit = service.delete(id.toLong())
        Assert.notNull(product)
    }

    @Test
    fun `create product`() {
        val product: Product = service.create(
            Product(
                1,
                "cafe",
                "tradicional",
                2.50
            )
        )
        Assert.notNull(product)
    }

    @Test
    fun `update product`(){
        val product: Unit = service.update(id.toLong(), Product(
            1,
            "cafe",
            "tradicional",
            2.50
        ))
        Assert.notNull(product)
    }
}
