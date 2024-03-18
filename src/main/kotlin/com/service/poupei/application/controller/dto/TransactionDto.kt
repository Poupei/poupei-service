package com.service.poupei.application.controller.dto

import com.service.poupei.domain.model.Transaction
import com.service.poupei.infra.database.entities.TransactionEntity
import java.time.LocalDateTime

data class TransactionDto (
        val transactionId: String,
        val userId: String,
        val method: String,
        val type: Int,
        val value: Double,
        val datetime: String,
        val accountId: String,
        val cardId: String,
        val description: String,
        val installment: Int,
        val maxInstallment: Int

) {
    companion object {
        fun from (transaction: Transaction): TransactionDto =
            TransactionDto(
                    transaction.transactionId!!,
                    transaction.userId,
                    transaction.method,
                    transaction.type,
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
