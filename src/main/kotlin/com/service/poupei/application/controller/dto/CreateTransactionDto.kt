package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.service.poupei.domain.enums.transaction.TransactionMethod
import com.service.poupei.domain.enums.transaction.TransactionType
import com.service.poupei.domain.model.Transaction
import java.math.BigDecimal

data class CreateTransactionDto(
    @JsonProperty("user_id")
    val userId: String,
    val method: TransactionMethod,
    val type: TransactionType,
    val value: BigDecimal,
    @JsonProperty("date_time")
    val dateTime: String,
    @JsonProperty("account_id")
    val accountId: String,
    @JsonProperty("card_id")
    val cardId: String,
    val description: String,
    val installment: Int,
    @JsonProperty("max_installment")
    val maxInstallment: Int
) {
    fun toModel(): Transaction =
        Transaction(
            userId = userId,
            method = method.toString(),
            type = type.toString(),
            value = value,
            datetime = dateTime,
            accountId = accountId,
            cardId = cardId,
            description = description,
            installment = installment,
            maxInstallment = maxInstallment
        )
}