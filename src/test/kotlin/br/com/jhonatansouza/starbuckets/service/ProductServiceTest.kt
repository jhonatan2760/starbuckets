package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Address
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.Provider
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert

@SpringBootTest
class ProductServiceTest {

    var repository: ProductRepository = TODO()

    var service: ProductService = ProductService(repository)

    private val id = ""

    @Test
    fun `when register a product, the price shouldnt be less than 0_99`() {
        assertThrows<GenericException> {
            service.create(
                createProduct(
                    price = 0.00
                )
            )
        }
    }

    @Test
    fun `when register a product and the price is more than 1 Real, should verify the product name`() {
        val response = service.create(
            createProduct(
                name = "Café Expresso", price = 14.0
            )
        )
        assert(response.name == "Café Expresso")
    }

    @Test
    fun `quando nome vier vazio, produto não pode ser criado`() {
        assertThrows<GenericException> {
            service.create(
                createProduct(
                    name = "",
                    price = 1.0

                )
            )


        }
    }

    private fun createProduct(name: String = "Product Name", price: Double): Product {
        return Product(
            "ssw32e3",
            name,
            "Description",
            price,
            provider = Provider(
                "akw3s",
                "cafe",
                address = Address(
                    "rua",
                    "09450-000",
                    "mary jones city",
                    "Ribeirao Pires",
                    "casa 1"
                )
            )
        )
    }

    @Test
    fun `Search product by id`() {
        val product: Product = service.getById(id.toString())
        Assert.notNull(product)
    }

    @Test
    fun `delete product by id`() {
        val product: Unit = service.delete(id.toString())
        Assert.notNull(product)
    }

    @Test
    fun `create product`() {
        val product: Product = service.create(
            Product(
                "randowId",
                "cafe",
                "tradicional",
                2.50,
                provider = Provider(
                    "akw3s",
                    "cafe",
                    address = Address(
                        "rua",
                        "09450-000",
                        "mary jones city",
                        "Ribeirao Pires",
                        "casa 1"
                    )
                )
            )
        )
        Assert.notNull(product)
    }
    @Test

    fun `update product`() {
        val product: Unit = service.update(
            id  , product = Product(
                "randowId",
                "cafe",
                "tradicional",
                2.50,
                provider = Provider(
                    "akw3s",
                    "cafe",
                    address = Address(
                        "rua",
                        "09450-000",
                        "mary jones city",
                        "Ribeirao Pires",
                        "casa 1"
                    )
                )
            )
        )
        Assert.notNull(product)
    }
}
