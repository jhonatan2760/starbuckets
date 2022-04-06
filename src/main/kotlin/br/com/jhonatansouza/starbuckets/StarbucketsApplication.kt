package br.com.jhonatansouza.starbuckets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class StarbucketsApplication {
}

    fun main(args: Array<String>) {
        runApplication<StarbucketsApplication>(*args)
    }
