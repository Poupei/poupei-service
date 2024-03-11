package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Bank

class CreateBankDto(
    private val name: String,
    private val code: String,
    private val logo: String
) {
    fun toModel(): Bank = Bank(
        bankId = null,
        name = name,
        code = code,
        logo = logo
    )
}
