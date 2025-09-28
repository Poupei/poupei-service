package com.service.poupei.application.usecase.transaction


import com.service.poupei.domain.gateways.TransactionGateway
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class CreateTransactionUseCase(
    private val transactionGateway: TransactionGateway
) {
    fun with(transaction: Transaction): Transaction =
            transactionGateway.createWith(transaction);
}