package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.BankAccountGateway
import com.service.poupei.domain.model.BankAccount
import org.springframework.stereotype.Component

@Component
class RetrieveAllBankAccountUseCase(
    private val bankAccountGateway: BankAccountGateway
) {
    fun all(): List<BankAccount> = bankAccountGateway.retrieveAll()
}
