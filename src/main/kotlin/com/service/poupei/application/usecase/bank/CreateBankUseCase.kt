package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.BankGateway
import com.service.poupei.domain.model.Bank
import org.springframework.stereotype.Component

@Component
class CreateBankUseCase(
    private val bankGateway: BankGateway
) {
    fun with(bank: Bank): Bank = bankGateway.createWith(bank)
}
