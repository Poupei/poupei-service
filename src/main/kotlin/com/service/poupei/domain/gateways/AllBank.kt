package com.service.poupei.domain.gateways

import com.service.poupei.domain.model.Bank

interface AllBank {
    fun retrieveAll(): List<Bank>
    fun retrieveWith(id: String): Bank
    fun createWith(bank: Bank): Bank
    fun updateWith(bank: Bank): Bank
    fun deleteWith(id: String): Bank
}