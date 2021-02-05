package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.exception.ProductException
import br.com.jhonatansouza.starbuckets.model.Product
import br.com.jhonatansouza.starbuckets.model.RespostaJson
import br.com.jhonatansouza.starbuckets.service.impl.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("/product")
class ProductController() {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/{id}")
    fun getByid(@PathVariable id: Long): ResponseEntity<Product?> {
        var product = productService.getById(id) ?:
                throw ProductException("product ${id} not found")
        return ResponseEntity(product, HttpStatus.OK)
    }

    @PostMapping()
    fun create(@RequestBody product: Product): ResponseEntity<RespostaJson> {
        productService.create(product)
        HttpStatus.CREATED
        val respostaJson = RespostaJson("OK", Date())
        return ResponseEntity(respostaJson, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<RespostaJson> {
        var status = HttpStatus.NOT_FOUND
        var respostaJson = RespostaJson("error", Date())
        if (productService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            respostaJson = RespostaJson("ok", Date())
            productService.delete(id)
        }
        return ResponseEntity(respostaJson, status)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (productService.getById(id) != null) {
            productService.update(id, product)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping()
    fun getAll(@RequestParam(required = false, defaultValue = "") localFilter: String): ResponseEntity<List<Product>>{
        var status = HttpStatus.OK
        val productList = productService.serchByName(localFilter)
        if (productList.size == 0){
            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity(productList, status)
    }

}