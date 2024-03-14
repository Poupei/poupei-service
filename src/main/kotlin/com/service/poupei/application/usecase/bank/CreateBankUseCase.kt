package com.service.poupei.application.usecase.bank

import com.service.poupei.domain.gateways.AllBank
import com.service.poupei.domain.model.Bank
import org.springframework.stereotype.Component

@Component
class CreateBankUseCase(
    private val allBank: AllBank
) {
    fun with(bank: Bank): Bank = allBank.createWith(bank)
}
