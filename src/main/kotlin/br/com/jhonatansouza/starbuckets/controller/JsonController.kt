package br.com.jhonatansouza.starbuckets.controller

import br.com.jhonatansouza.starbuckets.model.Client
import br.com.jhonatansouza.starbuckets.model.SimpleObject
import br.com.jhonatansouza.starbuckets.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class JsonController {
    @GetMapping("/json")
    fun get() = SimpleObject()

    @GetMapping("/client")
    fun getClient(): Client{
        var telefone = Telefone("11", "48251486", "fixo")
        var client = Client(1,"Luan", Date(), telefone)
        return client
    }
}