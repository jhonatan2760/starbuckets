package br.com.jhonatansouza.starbuckets.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class RespostaJson(val message: String = "",
                        @JsonFormat(pattern = "dd,MM,yyyy")
                        var date: Date)