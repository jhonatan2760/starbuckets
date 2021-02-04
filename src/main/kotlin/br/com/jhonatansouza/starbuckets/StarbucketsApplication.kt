package br.com.jhonatansouza.starbuckets

import br.com.jhonatansouza.starbuckets.model.Product
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class StarbucketsApplication {
    companion object {
        val initialProductResponse = arrayOf(
				Product(1, "Café", "café tradicional", 2.50),
				Product(2, "Café gelado", "Café tradicional gelado", 2.50),
				Product(3,"chá","chá mate",3.00),
				Product(4,"Café c/ leite","café tradicional com leite quente", 5.00)

				)
    }
	@Bean
	fun product() = ConcurrentHashMap<Long,Product>(initialProductResponse.associateBy(Product::id))

}


fun main(args: Array<String>) {
    runApplication<StarbucketsApplication>(*args)
}
