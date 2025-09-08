package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.AllBank
import org.springframework.stereotype.Component

@Component
class RetrieveBankUseCase(
    private val allBank: AllBank
) {
    fun with(id: String) = allBank.retrieveWith(id)
}
