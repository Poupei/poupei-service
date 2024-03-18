package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllTransaction
import com.service.poupei.domain.model.Transaction
import org.springframework.stereotype.Service

@Service
class TransactionService : AllTransaction{
    override fun createWith(transaction: Transaction): Transaction {
        TODO("Not yet implemented")
    }

    override fun retrieveAll(): List<Transaction> {
        TODO("Not yet implemented")
    }

    override fun retrieveWith(id: String): Transaction {
        TODO("Not yet implemented")
    }

    override fun updateWith(transaction: Transaction): Transaction {
        TODO("Not yet implemented")
    }

    override fun deleteWith(id: String): Transaction {
        TODO("Not yet implemented")
    }

}