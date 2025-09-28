package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.BankAccountGateway
import com.service.poupei.domain.model.BankAccount
import org.springframework.stereotype.Component

@Component
class CreateBankAccountUseCase(
    private val bankAccountGateway: BankAccountGateway
) {
    fun with(bankAccount: BankAccount) = bankAccountGateway.createWith(bankAccount)
}
