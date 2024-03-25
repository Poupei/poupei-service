package com.service.poupei.application.usecase.bankaccount

import com.service.poupei.domain.gateways.AllBankAccount
import org.springframework.stereotype.Component

@Component
class DeleteBankAccountUseCase(
    private val allBankAccount: AllBankAccount
) {
    fun with(id: String) = allBankAccount.deleteWith(id)
}
