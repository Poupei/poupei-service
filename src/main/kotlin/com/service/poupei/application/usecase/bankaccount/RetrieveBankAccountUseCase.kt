package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.AllBankAccount
import com.service.poupei.domain.model.BankAccount
import org.springframework.stereotype.Component

@Component
class RetrieveBankAccountUseCase(
    private val allBankAccount: AllBankAccount
) {
    fun with(id: String): BankAccount = allBankAccount.retrieveWith(id)
}
