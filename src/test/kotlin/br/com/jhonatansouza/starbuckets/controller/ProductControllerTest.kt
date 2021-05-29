package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.request.AddressRequest
import br.com.jhonatansouza.starbuckets.model.request.ProductRequest
import br.com.jhonatansouza.starbuckets.model.request.ProviderRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/product/v1/"

    @Nested
    @DisplayName("POST /api/products")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetProducts {
        @Test
        fun `test ahssa`() {
            mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(createRequest())
            }
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                }
        }
    }

    fun createRequest() =
        ProductRequest(
            "Bolacha Maria",
            "Bolacha redonda, doce, sabor água",
            1.99,
            ProviderRequest(
                "Bolachas Adria LTDA",
                AddressRequest(
                    "Rua José Paulo Machado",
                    "1293012-1239",
                    "Diadema",
                    "SP", "Fundos"
                )
            )
        )
}