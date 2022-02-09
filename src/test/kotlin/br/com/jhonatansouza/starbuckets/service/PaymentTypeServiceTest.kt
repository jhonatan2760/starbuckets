package br.com.jhonatansouza.starbuckets.service

import br.com.jhonatansouza.starbuckets.enum.IssuerEnum
import br.com.jhonatansouza.starbuckets.enum.PaymentEnum
import br.com.jhonatansouza.starbuckets.model.PaymentType
import br.com.jhonatansouza.starbuckets.repository.PaymentTypeRepository
import br.com.jhonatansouza.starbuckets.service.clients.VaultClient
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.internal.verification.Calls
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness

@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PaymentTypeServiceTest {

    @Mock
    private lateinit var client: VaultClient

    @Mock
    private lateinit var repository: PaymentTypeRepository

    @InjectMocks
    private lateinit var service: PaymentTypeService

    fun `when receive a credicard, should register`(){
        val paymentType = PaymentType(
            holderName = "Luan Santos Munoz",
            active = false,
            cardType = PaymentEnum.CREDIT,
            cardName = "Magalu",
            isPrincipal = true,
            issuer = IssuerEnum.VISA
        )

        assertThrows<Exception> {
            service.create(paymentType, "12093812019283", "11/26")
        }
    }

}