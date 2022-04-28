package br.com.jhonatansouza.starbuckets.model.entity

import br.com.jhonatansouza.starbuckets.enum.UserEnum

import javax.persistence.*

@Entity(name = "user_starbuckets")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    @Column(length = 255)
    val name: String,
    @Column(unique = true)
    val email: String,
    var password: String,
    val birthDate: String,
    val type: Enum<UserEnum>,
    val active: Boolean
)