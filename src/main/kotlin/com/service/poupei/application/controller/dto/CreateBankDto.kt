package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Bank

class CreateBankDto(
    val name: String,
    val code: String,
    val logo: String
) {
    fun toModel(): Bank = Bank(
        name = name,
        code = code,
        logo = logo
    )
}
