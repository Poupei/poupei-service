package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.BankGateway
import com.service.poupei.domain.model.Bank
import org.springframework.stereotype.Component

@Component
class DeleteBankUseCase(
    private val bankGateway: BankGateway
) {
    fun with(id: String): Bank = bankGateway.deleteWith(id)
}
