package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.model.Bank

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class BankDto (
    val bankId: String,
    val name: String,
    val code: String,
    val logo: String
) {
    companion object {
        fun from(bank: Bank): BankDto = BankDto(
            bankId = bank.bankId,
            name = bank.name,
            code = bank.code,
            logo = bank.logo
        )
    }
}
