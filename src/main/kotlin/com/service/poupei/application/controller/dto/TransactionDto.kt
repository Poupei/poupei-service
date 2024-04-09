package com.service.poupei.application.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.service.poupei.domain.enums.transaction.TransactionMethod
import com.service.poupei.domain.enums.transaction.TransactionType
import com.service.poupei.domain.model.Transaction
import java.math.BigDecimal

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class TransactionDto(
    val transactionId: String,
    val userId: String,
    val method: TransactionMethod,
    val type: TransactionType,
    val value: BigDecimal,
    val datetime: String,
    val accountId: String,
    val cardId: String,
    val description: String,
    val installment: Int,
    val maxInstallment: Int
) {
    companion object {
        fun from(transaction: Transaction): TransactionDto =
            TransactionDto(
                transaction.transactionId,
                transaction.userId,
                TransactionMethod.valueOf(transaction.method),
                TransactionType.valueOf(transaction.type),
                transaction.value,
                transaction.datetime,
                transaction.accountId,
                transaction.cardId,
                transaction.description,
                transaction.installment,
                transaction.maxInstallment
            )
    }
}
