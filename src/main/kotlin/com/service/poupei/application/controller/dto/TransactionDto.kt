package com.service.poupei.application.controller.dto

import com.service.poupei.infra.database.entities.TransactionEntity
import java.time.LocalDateTime

data class TransactionDto (
        val id: String,
        val value: Double,
        val dateTime: LocalDateTime,
        val description: String,
        val method: String,
        val type: Int,
        val installment: Int,
        val maxInstallment: Int,
        val accountId: String,
        val cardId: String

) {
    companion object {
//        fun from (transaction: TransactionEntity): TransactionDto = TransactionDto(
//                id = transaction.id,
//        )
    }
}
