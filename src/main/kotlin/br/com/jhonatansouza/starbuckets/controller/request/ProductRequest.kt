package br.com.jhonatansouza.starbuckets.controller.request

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductRequest(val id: Long,
                          val name: String,
                          val description: String,
                          val price: Double
)
