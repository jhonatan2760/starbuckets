package br.com.jhonatansouza.starbuckets.controller.request

import br.com.jhonatansouza.starbuckets.model.Product

data class ProductRequest(val name: String){

    fun toModel() = Product(name = this.name)

}
