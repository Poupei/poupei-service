package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.model.BankAccount

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
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
