package br.com.jhonatansouza.starbuckets.model

import br.com.jhonatansouza.starbuckets.model.entity.Product
import br.com.jhonatansouza.starbuckets.model.entity.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")
data class Purchase(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,
    @ManyToOne
    @JoinColumn(name = "userId")
    val user: User,
    @ManyToMany
    @JoinTable(name = "purchaseProduct",
    joinColumns = [JoinColumn(name = "purchaseId")],
    inverseJoinColumns = [JoinColumn(name = "productId")])
    val product: List<Product>,
    @Column
    val price: Double,
    @Column(name = "createdAt")
    val createdAt: LocalDateTime = LocalDateTime.now()
)