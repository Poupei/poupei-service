package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.BankAccount

data class BankAccountDto (
    val bankAccountId: String,
    val userId: String,
    val bankId: String,
    val name: String
) {
    companion object {
        fun from(bankAccount: BankAccount) = BankAccountDto(
            bankAccountId = bankAccount.bankAccountId,
            userId = bankAccount.userId,
            bankId = bankAccount.bankId,
            name = bankAccount.name
        )
    }
}
