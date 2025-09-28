package com.service.poupei.application.usecase.transaction

import com.service.poupei.domain.gateways.TransactionGateway
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class UpdateTransactionUseCase(
    private val transactionGateway: TransactionGateway
) {
    fun with(id: String, transaction: Transaction) : Transaction =
            transactionGateway.updateWith(id, transaction);
}