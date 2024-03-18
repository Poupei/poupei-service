package com.service.poupei.application.usecase.transaction


import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class CreateTransactionUseCase(
    private val allTransaction: AllTransaction
) {
    fun with(transaction: Transaction): Transaction =
            allTransaction.createWith(transaction);
}