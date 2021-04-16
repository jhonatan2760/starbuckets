package br.com.jhonatansouza.starbuckets.repository

import br.com.jhonatansouza.starbuckets.model.Provider
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProviderRepository: MongoRepository<Provider,String>