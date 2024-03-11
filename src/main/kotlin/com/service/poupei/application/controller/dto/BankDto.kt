package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Bank

data class BankDto (
    val bankId: String,
    val name: String,
    val code: String,
    val logo: String
) {
    companion object {
        fun from(bank: Bank): BankDto = BankDto(
            bankId = bank.bankId!!,
            name = bank.name,
            code = bank.code,
            logo = bank.logo
        )
    }
}
