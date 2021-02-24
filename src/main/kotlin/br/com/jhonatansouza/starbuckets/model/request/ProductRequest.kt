package br.com.jhonatansouza.starbuckets.model.request

import javax.validation.constraints.NotEmpty

data class ProductRequest(val id: Long,
                          @NotEmpty(message = "value cannot be empty")
                          val name: String,
                          val description: String,
                          val price: Double
)
