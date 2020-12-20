package br.com.jhonatansouza.starbuckets.controller.response

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


data class ProductResponse(val name: String, val price: Double)