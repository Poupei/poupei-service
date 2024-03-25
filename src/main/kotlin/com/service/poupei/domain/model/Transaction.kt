package com.service.poupei.domain.model

import com.service.poupei.infra.database.entities.TransactionEntity
import java.util.UUID

data class Transaction(
        val transactionId: String = UUID.randomUUID().toString(),
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
    fun toEntity() : TransactionEntity =
        TransactionEntity(
            transactionId = this.transactionId,
            userId = this.userId,
            method = this.method,
            type = this.type,
            value = this.value,
            datetime = this.datetime,
            accountId = this.accountId,
            cardId = this.cardId,
            description = this.description,
            installment = this.installment,
            maxInstallment = this.maxInstallment
        )
}