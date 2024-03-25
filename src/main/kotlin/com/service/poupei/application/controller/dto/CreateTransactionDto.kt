package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Transaction


data class CreateTransactionDto(
    private val userId: String,
    private val method: String,
    private val type: Int,
    private val value: Double,
    private val dateTime: String,
    private val accountId: String,
    private val cardId: String,
    private val description: String,
    private val installment: Int,
    private val maxInstallment: Int
) {

    fun toModel(): Transaction  =
            Transaction(
                userId = userId,
                method = method,
                type = type,
                value = value,
                datetime = dateTime,
                accountId = accountId,
                cardId = cardId,
                description = description,
                installment = installment,
                maxInstallment = maxInstallment
            )
}
