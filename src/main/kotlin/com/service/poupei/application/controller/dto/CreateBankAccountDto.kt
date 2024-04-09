package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.service.poupei.domain.model.BankAccount

data class CreateBankAccountDto (
    @JsonProperty("user_id")
    val userId: String,
    @JsonProperty("bank_id")
    val bankId: String,
    val name: String
) {
    fun toModel(): BankAccount = BankAccount(
        userId = userId,
        bankId = bankId,
        name = name
    )
}
