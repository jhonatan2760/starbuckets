package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService() {

    fun createProduct(product: Product){

        if(product.name == "Café"){

        }else{
            throw Exception("Erro")
        }

    }

}