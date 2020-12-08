package br.com.jhonatansouza.starbuckets.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AgeToggle {

    @Value("\${feature.toggle.age}")
    lateinit var age: String

}