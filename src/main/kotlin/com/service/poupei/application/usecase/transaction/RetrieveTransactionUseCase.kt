package com.service.poupei.application.usecase.transaction

import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Component

@Component
class RetrieveTransactionUseCase(
    private val allTransaction: AllTransaction
) {
    fun with(id: String) : Transaction =
            allTransaction.retrieveWith(id);
}