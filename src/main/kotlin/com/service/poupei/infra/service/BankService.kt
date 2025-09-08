package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllBank
import com.service.poupei.domain.model.Bank
import com.service.poupei.infra.database.repositories.BankEntityRepository
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class BankService(
    private val bankEntityRepository: BankEntityRepository
) : AllBank {
    override fun retrieveAll(): List<Bank> =
        bankEntityRepository.findAll().map { it.toModel() }

    override fun retrieveWith(id: String): Bank =
        bankEntityRepository.findById(id).getOrNull()?.toModel() ?: throw NotFoundException(
            "Not found bank with id $id"
        )

    override fun createWith(bank: Bank): Bank =
        bankEntityRepository.save(bank.toEntity()).toModel()

    override fun updateWith(bank: Bank): Bank =
        retrieveWith(bank.bankId).let {
            bankEntityRepository.save(bank.toEntity()).toModel()
        }

    override fun deleteWith(id: String): Bank =
        retrieveWith(id).let {
            bankEntityRepository.deleteById(id)
            it
        }
}