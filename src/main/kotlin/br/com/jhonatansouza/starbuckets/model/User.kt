package br.com.jhonatansouza.starbuckets.model

import br.com.jhonatansouza.starbuckets.enum.UserEnum
import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 123,
    @Column(length = 255)
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String,
    val type: Enum<UserEnum>,
    val active: Boolean
)