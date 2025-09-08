package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.BankAccount

interface AllBankAccount {
    fun retrieveAll(): List<BankAccount>
    fun retrieveWith(id: String): BankAccount
    fun createWith(bankAccount: BankAccount): BankAccount
    fun updateWith(bankAccount: BankAccount): BankAccount
    fun deleteWith(id: String): BankAccount
}
