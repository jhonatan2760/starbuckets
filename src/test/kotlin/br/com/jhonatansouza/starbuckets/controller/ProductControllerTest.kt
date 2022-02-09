package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@RunWith(SpringRunner::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
class ProductControllerTest @Autowired constructor(
    @Autowired var testRestTemplate: TestRestTemplate
) {

    val baseUrl = "/api/product/v1/"

    @Test
    fun testCreateProductController() {
        val result = testRestTemplate.postForEntity<ProductRequest>("/api/product/v1", createRequest())
        print(result.statusCode)
        assertNotNull(result)
    }

    @Test
    fun testShouldNotCreateProduct() {
        assertThrows<Exception> {
            val result = testRestTemplate.postForEntity<ProductRequest>("/api/product/v1", wrongProductRequest())
            print(result.statusCode)
        }
    }

    @Test
    fun shouldReturnHeaderHttpLocationHeader(){
        val result = testRestTemplate.postForEntity<ProductRequest>("/api/product/v1", createRequest())
        assertEquals(result.statusCode, HttpStatus.CREATED)
    }

    fun createRequest() =
        ProductRequest(
            "Bolacha Maria",
            "Bolacha redonda, doce, sabor água",
            1.99
        )

    fun wrongProductRequest() =
        ProductRequest("",
        description = "Produto altamente nutritivo",
        price = 1.99)
}