package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.BankGateway
import org.springframework.stereotype.Component

@Component
class RetrieveBankUseCase(
    private val bankGateway: BankGateway
) {
    fun with(id: String) = bankGateway.retrieveWith(id)
}
