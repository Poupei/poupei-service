package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.AllBank
import org.springframework.stereotype.Component

@Component
class RetrieveAllBankUseCase(
    private val allBank: AllBank
) {
    fun all() = allBank.retrieveAll()
}
