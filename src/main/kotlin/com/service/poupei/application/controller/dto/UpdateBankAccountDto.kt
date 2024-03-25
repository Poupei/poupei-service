package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.BankAccount

data class UpdateBankAccountDto (
    val bankAccountId: String,
    val userId: String,
    val bankId: String,
    val name: String
) {
    fun toModel(): BankAccount = BankAccount(
        bankAccountId = bankAccountId,
        userId = userId,
        bankId = bankId,
        name = name
    )
}