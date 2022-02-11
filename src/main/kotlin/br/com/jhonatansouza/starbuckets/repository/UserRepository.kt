package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>