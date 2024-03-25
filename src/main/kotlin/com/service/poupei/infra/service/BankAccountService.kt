package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllBankAccount
import com.service.poupei.domain.model.BankAccount
import com.service.poupei.infra.database.repositories.BankAccountEntityRepository
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class BankAccountService(
    private val bankAccountEntityRepository: BankAccountEntityRepository
) : AllBankAccount {
    override fun retrieveAll(): List<BankAccount> =
        bankAccountEntityRepository.findAll().map { it.toModel() }

    override fun retrieveWith(id: String): BankAccount =
        bankAccountEntityRepository.findById(id).getOrNull()?.toModel() ?: throw NotFoundException(
            "Not found bank account with id $id"
        )

    override fun createWith(bankAccount: BankAccount): BankAccount =
        bankAccountEntityRepository.save(bankAccount.toEntity()).toModel()

    override fun updateWith(bankAccount: BankAccount): BankAccount =
        retrieveWith(bankAccount.bankAccountId).let {
            bankAccountEntityRepository.save(bankAccount.toEntity()).toModel()
        }

    override fun deleteWith(id: String): BankAccount =
        retrieveWith(id).let {
            bankAccountEntityRepository.deleteById(id)
            it
        }
}