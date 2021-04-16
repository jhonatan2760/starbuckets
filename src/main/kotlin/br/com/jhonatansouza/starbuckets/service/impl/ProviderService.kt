package br.com.jhonatansouza.starbuckets.service.impl
import br.com.jhonatansouza.starbuckets.exception.GenericException
import br.com.jhonatansouza.starbuckets.model.Provider
import br.com.jhonatansouza.starbuckets.repository.ProviderRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProviderService(val repository: ProviderRepository) {

    fun create(provider: Provider): Provider {

        provider.id = UUID.randomUUID().toString()
        return this.repository.save(provider)
    }

    fun getById(id: String): Provider =
        repository.findById(id).get()

    fun delete(id: String) {
        if (getById(id) != null) {
        } else {
            throw GenericException("Provider not fund $id", NOT_FOUND.value())
        }
    }

    fun update(id: String, provider: Provider) {
        if (this.getById(id) != null) {
            delete(id)
            create(provider)
        } else {
            throw GenericException("Provider not fund $id", NOT_FOUND.value())

        }



    }
}