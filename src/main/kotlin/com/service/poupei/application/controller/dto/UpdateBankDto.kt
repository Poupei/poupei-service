package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Bank

data class UpdateBankDto (
    val name: String,
    val code: String,
    val logo: String
) {
    fun toModelWith(id: String): Bank = Bank(
        bankId = id,
        name = name,
        code = code,
        logo = logo
    )
}
