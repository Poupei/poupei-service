package com.service.poupei.application.usecase.transaction

import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class RetrieveAllTransactionsUseCase(
    private val allTransaction: AllTransaction
) {
    fun all(): List<Transaction> =
            allTransaction.retrieveAll();
}