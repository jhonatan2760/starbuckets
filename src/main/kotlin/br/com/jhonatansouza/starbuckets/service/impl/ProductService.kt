package br.com.jhonatansouza.starbuckets.service.impl

import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream

@Service
class ProductService(val repository: ProductRepository) {

    fun create(product: Product): Product {
        valida(product)
        product.id = UUID.randomUUID().toString()
        return this.repository.save(product)
    }

    fun delete(id: String) {
        if(this.getById(id) != null){
        }else{
            throw GenericException("Product not found with id $id", HttpStatus.NOT_FOUND.value())
        }
    }

    fun getAll(): List<Product> =
        this.repository.findAll()

    fun getById(id: String): Product =
        this.repository.findById(id).get()

    fun update(id: String, product: Product) {
        if(getById(id) != null){
            delete(id)
            create(product)
        }else{
            throw GenericException("Product not found", HttpStatus.NOT_FOUND.value())
        }
    }

    fun createData(): MutableSet<String>? {

        val item = Arrays.asList("Café tipo", "Leite tipo", "Vitamina", "Sobremesa", "água de", "Leite de", "Sorvete de", "Pão de");
        val recheio = Arrays.asList("Expresso", "Morango", "Beterraba", "Laranja", "Chocolate", "Uva", "Açucar", "Mamão", "Suspiro", "Agridoce");

            val itens = Stream.generate(Supplier { Math.random() })
            .map { "${item[(Math.random() * item.size).toInt()]} - ${recheio[(Math.random() * recheio.size).toInt()]}" }
            .limit(600)
            .peek(System.out::println)
            .collect(Collectors.toSet())

        val itensPag = itens

        return itensPag
    }
    fun valida(product: Product) {
        if (product.name.isEmpty())
            throw GenericException(message = "value cannot be empty", HttpStatus.BAD_REQUEST.value())

        if (product.price < 1)
            throw GenericException(message = "price cannot be less than 1 real", HttpStatus.BAD_REQUEST.value())
    }
}