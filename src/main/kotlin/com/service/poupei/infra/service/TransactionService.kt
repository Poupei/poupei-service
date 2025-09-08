package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import com.service.poupei.infra.database.repositories.TransactionEntityRepository
import com.service.poupei.infra.exceptions.NotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class TransactionService(
    private val transactionEntityRepository: TransactionEntityRepository
) : AllTransaction{
    override fun createWith(transaction: Transaction): Transaction =
        transactionEntityRepository.save(transaction.toEntity()).toModel()

    override fun retrieveAll(): List<Transaction> =
        transactionEntityRepository.findAll().map { it.toModel() }

    override fun retrieveWith(id: String): Transaction =
        transactionEntityRepository.findById(id).getOrNull()?.toModel() ?: throw NotFoundException(
            "Not found transaction with id $id"
        )

    override fun updateWith(id: String ,transaction: Transaction): Transaction =
        retrieveWith(id).let {
            transactionEntityRepository.save(transaction.toEntity()).toModel()
        }


    override fun deleteWith(id: String): Transaction =
        retrieveWith(id).let {
            transactionEntityRepository.deleteById(id)
            it
        }

}