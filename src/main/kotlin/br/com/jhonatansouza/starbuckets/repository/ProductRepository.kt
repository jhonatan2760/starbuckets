package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>
