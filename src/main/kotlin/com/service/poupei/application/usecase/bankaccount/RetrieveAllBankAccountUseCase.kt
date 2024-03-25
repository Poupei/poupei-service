package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.AllBankAccount
import com.service.poupei.domain.model.BankAccount
import org.springframework.stereotype.Component

@Component
class RetrieveAllBankAccountUseCase(
    private val allBankAccount: AllBankAccount
) {
    fun all(): List<BankAccount> = allBankAccount.retrieveAll()
}
