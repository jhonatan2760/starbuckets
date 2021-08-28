package br.com.jhonatansouza.starbuckets.service


import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness
import org.springframework.boot.test.context.SpringBootTest

@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
class ProductServiceTest {

    @Mock
    lateinit var repository: ProductRepository

    @InjectMocks
    lateinit var service: ProductService

    private val id = ""

    @Test
    fun `when create a product should validate if the name is not empty`() {
        assertThrows<GenericException> {
            service.create(product = createProduct(name = "", price = 1.99))
        }
    }

    @Test
    fun `when create a product should validate if the price is GREATER than 0`() {
        assertThrows<GenericException> {
            service.create(product = createProduct(name = "", price = 0.00))
        }
    }

    private fun createProduct(
        name: String = "Product Name",
        description: String = "120938102830912803108",
        price: Double
    ): Product {
        return Product(
            1,
            name,
            description,
            price
        )
    }

    @Test
    fun`when create product`(){
        var product = Product(123,
            "café",
        "muito quente",
        3.89)

        whenever(service.create(product))
    }



}