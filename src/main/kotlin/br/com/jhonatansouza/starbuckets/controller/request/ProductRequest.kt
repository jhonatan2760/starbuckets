package br.com.jhonatansouza.starbuckets.controller.request

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductRequest(val name: String,
                          val price: Double,
                          val description: String) {

    fun toModel() = Product(name = this.name, price = this.price, description = this.description)

}
