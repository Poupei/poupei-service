package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.BankAccountGateway
import org.springframework.stereotype.Component

@Component
class DeleteBankAccountUseCase(
    private val bankAccountGateway: BankAccountGateway
) {
    fun with(id: String) = bankAccountGateway.deleteWith(id)
}
