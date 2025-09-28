package com.service.poupei.application.usecase.transaction

import com.service.poupei.domain.gateways.TransactionGateway
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class RetrieveAllTransactionsUseCase(
    private val transactionGateway: TransactionGateway
) {
    fun all(): List<Transaction> =
            transactionGateway.retrieveAll();
}