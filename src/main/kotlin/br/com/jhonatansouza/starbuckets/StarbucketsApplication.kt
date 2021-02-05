package br.com.jhonatansouza.starbuckets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarbucketsApplication {
}

    fun main(args: Array<String>) {
        runApplication<StarbucketsApplication>(*args)
    }
