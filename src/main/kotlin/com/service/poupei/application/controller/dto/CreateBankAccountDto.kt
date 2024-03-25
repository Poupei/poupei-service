package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.BankAccount

data class CreateBankAccountDto (
    val userId: String,
    val bankId: String,
    val name: String
) {
    fun toModel(): BankAccount = BankAccount(
        userId = userId,
        bankId = bankId,
        name = name
    )
}
