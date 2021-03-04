package br.com.jhonatansouza.starbuckets.model.request

data class ProductRequest(val id: Long,
                          val name: String,
                          val description: String,
                          val price: Double
)
