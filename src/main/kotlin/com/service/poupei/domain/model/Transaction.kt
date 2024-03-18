package com.service.poupei.domain.model

data class Transaction(
        val transactionId: String?,
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
)