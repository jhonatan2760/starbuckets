package br.com.jhonatansouza.starbuckets

import br.com.jhonatansouza.starbuckets.controller.response.ProductResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarbucketsApplication



	fun main(args: Array<String>) {
		runApplication<StarbucketsApplication>(*args)
	}
