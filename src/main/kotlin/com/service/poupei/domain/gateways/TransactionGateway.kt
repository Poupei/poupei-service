package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.Transaction


interface TransactionGateway {

    fun createWith(transaction: Transaction): Transaction

    fun retrieveAll(): List<Transaction>

    fun retrieveWith(id: String): Transaction

    fun updateWith(id: String, transaction: Transaction): Transaction

    fun deleteWith(id: String): Transaction
}