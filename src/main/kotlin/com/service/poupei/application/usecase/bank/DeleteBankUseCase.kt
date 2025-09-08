package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.AllBank
import com.service.poupei.domain.model.Bank
import org.springframework.stereotype.Component

@Component
class DeleteBankUseCase(
    private val allBank: AllBank
) {
    fun with(id: String): Bank = allBank.deleteWith(id)
}
