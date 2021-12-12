package br.com.jhonatansouza.starbuckets.model

import br.com.jhonatansouza.starbuckets.enum.UserEnum
import javax.persistence.*

@Entity(

)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @Column(length = 255)
    val name: String,
    @Column(unique = true)
    val email: String,
    var password: String,
    val birthDate: String,
    val type: Enum<UserEnum>,
    val active: Boolean
)