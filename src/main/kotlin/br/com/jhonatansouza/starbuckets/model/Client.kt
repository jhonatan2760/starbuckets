package br.com.jhonatansouza.starbuckets.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Client(

        val id: Long,
        val name: String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        val date: Date,
        var telefone: Telefone?
)
data class Telefone(
        val ddd: String,
        val number: String,
        val tipe: String
)