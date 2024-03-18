package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.Transaction


interface AllTransaction {

    fun createWith(transaction: Transaction): Transaction

    fun retrieveAll(): List<Transaction>

    fun retrieveWith(id: String): Transaction

    fun updateWith(transaction: Transaction): Transaction

    fun deleteWith(id: String): Transaction
}