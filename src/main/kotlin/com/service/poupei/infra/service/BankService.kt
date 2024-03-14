package com.service.poupei.infra.service

import com.service.poupei.domain.gateways.AllBank
import com.service.poupei.domain.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService : AllBank {
    override fun retrieveAll(): List<Bank> {
        TODO("Not yet implemented")
    }

    override fun retrieveWith(id: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createWith(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateWith(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteWith(id: String): Bank {
        TODO("Not yet implemented")
    }
}