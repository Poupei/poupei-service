package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.service.poupei.domain.model.BankAccount

data class UpdateBankAccountDto (
    @JsonProperty("bank_account_id")
    val bankAccountId: String,
    @JsonProperty("user_id")
    val userId: String,
    @JsonProperty("bank_id")
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