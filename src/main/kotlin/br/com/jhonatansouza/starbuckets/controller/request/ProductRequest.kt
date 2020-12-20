package br.com.jhonatansouza.starbuckets.controller.request

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductRequest(val id: String,
                          val name: String,
                          val price: Double
) {

    fun toModel() = Product(id = this.id, name = this.name, price = this.price)

}
