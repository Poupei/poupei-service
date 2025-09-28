package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.BankGateway
import org.springframework.stereotype.Component

@Component
class RetrieveAllBankUseCase(
    private val bankGateway: BankGateway
) {
    fun all() = bankGateway.retrieveAll()
}
