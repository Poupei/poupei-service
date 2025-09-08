package com.service.poupei.application.usecase.transaction

import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class UpdateTransactionUseCase(
    private val allTransaction: AllTransaction
) {
    fun with(id: String, transaction: Transaction) : Transaction =
            allTransaction.updateWith(id, transaction);
}